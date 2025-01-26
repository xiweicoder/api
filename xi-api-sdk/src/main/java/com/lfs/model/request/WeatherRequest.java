package com.lfs.model.request;

import com.lfs.model.params.WeatherParams;
import com.lfs.model.enums.RequestMethodEnum;
import com.lfs.model.response.NameResponse;
import com.lfs.model.response.ResultResponse;
import lombok.experimental.Accessors;

/**
 * @Author: 西尾Ink
 * @Date: 2024/09/22 10:11:43
 * @Version: 1.0
 * @Description: 获取天气请求
 */
@Accessors(chain = true)
public class WeatherRequest extends BaseRequest<WeatherParams, ResultResponse> {

    @Override
    public String getPath() {
        return "/weather";
    }

    /**
     * 获取响应类
     *
     * @return {@link Class}<{@link NameResponse}>
     */
    @Override
    public Class<ResultResponse> getResponseClass() {
        return ResultResponse.class;
    }


    @Override
    public String getMethod() {
        return RequestMethodEnum.GET.getValue();
    }
}
