package com.lfs.utils;

import cn.hutool.core.bean.BeanUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lfs.exception.ApiException;
import com.lfs.exception.ErrorCode;
import com.lfs.model.response.ResultResponse;

import java.util.Map;

import static com.lfs.utils.RequestUtils.get;


/**
 * @Author: 西尾ink
 * @Date: 2024年09月22日 17:18
 * @Version: 1.0
 * @Description:
 */
public class ResponseUtils {
    public static Map<String, Object> responseToMap(String response) {
        return new Gson().fromJson(response, new TypeToken<Map<String, Object>>() {
        }.getType());
    }

    public static <T> ResultResponse baseResponse(String baseUrl, T params) throws ApiException {
        String response = null;
        try {
            response = get(baseUrl, params);
            Map<String, Object> fromResponse = responseToMap(response);
            ResultResponse baseResponse = new ResultResponse();

            if (BeanUtil.isEmpty(fromResponse.get("success"))) {
                baseResponse.setData(fromResponse);
                return baseResponse;
            }
            fromResponse.remove("success");
            baseResponse.setData(fromResponse);
            return baseResponse;
        } catch (ApiException e) {
            throw new ApiException(ErrorCode.OPERATION_ERROR, "构建url异常");
        }
    }
}
