package com.lfs.service.inner.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lfs.common.ErrorCode;
import com.lfs.exception.BusinessException;
import com.lfs.model.entity.User;
import com.lfs.qiapicommon.model.vo.UserVO;
import com.lfs.qiapicommon.service.inner.InnerUserService;
import com.lfs.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.BeanUtils;

import javax.annotation.Resource;

/**
 * @Author: 西尾ink
 * @Date: 2024年09月15日 22:54
 * @Version: 1.0
 * @Description:
 */
@DubboService
public class InnerUserServiceImpl implements InnerUserService {
    @Resource
    private UserService userService;

    @Override
    public UserVO getInvokeUserByAccessKey(String accessKey) {
        if (StringUtils.isAnyBlank(accessKey)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userLambdaQueryWrapper.eq(User::getAccessKey, accessKey);
        User user = userService.getOne(userLambdaQueryWrapper);
        if (user == null) {
            return null;
        }
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(user, userVO);
        return userVO;
    }
}
