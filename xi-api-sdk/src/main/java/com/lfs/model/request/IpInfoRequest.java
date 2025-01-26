package com.lfs.model.request;

import com.lfs.model.enums.RequestMethodEnum;
import com.lfs.model.params.IpInfoParams;
import com.lfs.model.response.ResultResponse;
import com.lfs.model.response.NameResponse;
import lombok.experimental.Accessors;

/**
 * @Author: 西尾Ink
 * @Date: 2024/09/22 09:04:04
 * @Version: 1.0
 * @Description: 获取ip地址请求
 */
@Accessors(chain = true)
public class IpInfoRequest extends BaseRequest<IpInfoParams, ResultResponse> {

    @Override
    public String getPath() {
        return "/ipInfo";
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
