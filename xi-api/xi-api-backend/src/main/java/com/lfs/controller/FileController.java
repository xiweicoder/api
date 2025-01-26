package com.lfs.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.io.FileUtil;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.ObjectMetadata;
import com.lfs.common.BaseResponse;
import com.lfs.common.ErrorCode;
import com.lfs.common.ResultUtils;
import com.lfs.model.entity.User;
import com.lfs.model.enums.FileUploadBizEnum;
import com.lfs.model.enums.ImageStatusEnum;
import com.lfs.model.file.UploadFileRequest;
import com.lfs.model.vo.ImageVo;
import com.lfs.model.vo.UserVO;
import com.lfs.service.UserService;
import com.lfs.utils.FileUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.Arrays;

/**
 * 文件接口
 *
 * @author 西尾Ink
 */
@RestController
@RequestMapping("/file")
@Slf4j
public class FileController {
    private static final long ONE_M = 2 * 1024 * 1024L;
    @Resource
    private UserService userService;
//    @Resource
//    private CosManager cosManager;
//    @Resource
//    private CosClientConfig cosClientConfig;


    /**
     * 上传文件
     *
     * @param multipartFile     多部分文件
     * @param uploadFileRequest 上传文件请求
     * @param request           请求
     * @return {@link BaseResponse}<{@link ImageVo}>
     */
    @PostMapping("/upload")
    public BaseResponse<ImageVo> uploadFile(@RequestPart("file") MultipartFile multipartFile, UploadFileRequest uploadFileRequest, HttpServletRequest request) {
        //工具类获取值
        String endpoint = FileUtils.END_POINT;
        String accessKeyId = FileUtils.KEY_ID;
        String accessKeySecret = FileUtils.KEY_SECRET;
        String bucketName = FileUtils.BUCKET_NAME;
        InputStream inputStream = null;
        String datePath = new DateTime().toString("yyyy-MM-dd");
        String biz = uploadFileRequest.getBiz();
        FileUploadBizEnum fileUploadBizEnum = FileUploadBizEnum.getEnumByValue(biz);
        ImageVo imageVo = new ImageVo();
        if (fileUploadBizEnum == null) {
            return uploadError(imageVo, multipartFile, "上传失败,请重试.");
        }
        String result = validFile(multipartFile, fileUploadBizEnum);
        if (!"success".equals(result)) {
            return uploadError(imageVo, multipartFile, result);
        }
        UserVO loginUser = userService.getLoginUser(request);
        // 文件目录：根据业务、用户来划分
        String filename = datePath + "/" + multipartFile.getOriginalFilename();
        String filepath = String.format("/%s/%s/%s", fileUploadBizEnum.getValue(), loginUser.getId(), filename);
        File file = null;

        try {
            inputStream = multipartFile.getInputStream();

            // 上传文件
            file = File.createTempFile(filepath, null);
            multipartFile.transferTo(file);
            OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
            // 判断文件是否存在
            boolean exists = ossClient.doesObjectExist(bucketName, filename);
            if (exists) {
                // 如果文件已存在，则先删除原来的文件再进行覆盖
                ossClient.deleteObject(bucketName, filename);
            }
            // 创建上传Object的Metadata
            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentLength(inputStream.available());
            objectMetadata.setContentType(getcontentType(filename.substring(filename.lastIndexOf("."))));
            objectMetadata.setContentDisposition("attachment; filename=" + URLEncoder.encode(filename, "UTF-8"));

            //调用oss实例中的方法实现上传
            //参数1： Bucket名称
            //参数2： 上传到oss文件路径和文件名称 /aa/bb/1.jpg
            //参数3： 上传文件的输入流
            ossClient.putObject(bucketName, filename, inputStream);

            // 关闭OSSClient。
            ossClient.shutdown();

            imageVo.setName(multipartFile.getOriginalFilename());
            imageVo.setUid(RandomStringUtils.randomAlphanumeric(8));
            imageVo.setStatus(ImageStatusEnum.SUCCESS.getValue());
            imageVo.setUrl("https://" + bucketName + "." + endpoint + "/" + filename);

            loginUser.setUserAvatar(imageVo.getUrl());
            User user = BeanUtil.copyProperties(loginUser, User.class);
            user.setUserAvatar(imageVo.getUrl());
            userService.updateById(user);
            // 返回可访问地址
            return ResultUtils.success(imageVo);
        } catch (Exception e) {
            log.error("file upload error, filepath = " + filepath, e);
            return uploadError(imageVo, multipartFile, "上传失败,请重试");
        } finally {
            if (file != null) {
                // 删除临时文件
                boolean delete = file.delete();
                if (!delete) {
                    log.error("file delete error, filepath = {}", filepath);
                }
            }
        }
    }

    private BaseResponse<ImageVo> uploadError(ImageVo imageVo, MultipartFile multipartFile, String message) {
        imageVo.setName(multipartFile.getOriginalFilename());
        imageVo.setUid(RandomStringUtils.randomAlphanumeric(8));
        imageVo.setStatus(ImageStatusEnum.ERROR.getValue());
        return ResultUtils.error(imageVo, ErrorCode.OPERATION_ERROR, message);
    }

    /**
     * 有效文件
     * 校验文件
     *
     * @param fileUploadBizEnum 业务类型
     * @param multipartFile     多部分文件
     */
    private String validFile(MultipartFile multipartFile, FileUploadBizEnum fileUploadBizEnum) {
        // 文件大小
        long fileSize = multipartFile.getSize();
        // 文件后缀
        String fileSuffix = FileUtil.getSuffix(multipartFile.getOriginalFilename());
        if (FileUploadBizEnum.USER_AVATAR.equals(fileUploadBizEnum)) {
            if (fileSize > ONE_M) {
                return "文件大小不能超过 1M";
            }
            if (!Arrays.asList("jpeg", "jpg", "svg", "png", "webp", "jfif").contains(fileSuffix)) {
                return "文件类型错误";
            }
        }
        return "success";
    }

    public static String getcontentType(String filenameExtension) {
        if (filenameExtension.equalsIgnoreCase("bmp")) {
            return "image/bmp";
        }
        if (filenameExtension.equalsIgnoreCase("gif")) {
            return "image/gif";
        }
        if (filenameExtension.equalsIgnoreCase("jpeg") || filenameExtension.equalsIgnoreCase("jpg")
                || filenameExtension.equalsIgnoreCase("png")) {
            return "image/jpeg";
        }
        if (filenameExtension.equalsIgnoreCase("html")) {
            return "text/html";
        }
        if (filenameExtension.equalsIgnoreCase("txt")) {
            return "text/plain";
        }
        if (filenameExtension.equalsIgnoreCase("vsd")) {
            return "application/vnd.visio";
        }
        if (filenameExtension.equalsIgnoreCase("pptx") || filenameExtension.equalsIgnoreCase("ppt")) {
            return "application/vnd.ms-powerpoint";
        }
        if (filenameExtension.equalsIgnoreCase("docx") || filenameExtension.equalsIgnoreCase("doc")) {
            return "application/msword";
        }
        if (filenameExtension.equalsIgnoreCase("xml")) {
            return "text/xml";
        }
        return "application/octet-stream";
    }
}
