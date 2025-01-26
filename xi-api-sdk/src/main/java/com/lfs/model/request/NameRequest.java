package com.lfs.model.request;

import com.lfs.model.enums.RequestMethodEnum;
import com.lfs.model.params.NameParams;
import com.lfs.model.response.NameResponse;
import lombok.experimental.Accessors;

/**
 * @Author: 西尾Ink
 * @Date: 2024年09月17日 08:38
 * @Version: 1.0
 * @Description:
 */
@Accessors(chain = true)
public class NameRequest extends BaseRequest<NameParams, NameResponse> {

    @Override
    public String getPath() {
        return "/name";
    }

    /**
     * 获取响应类
     *
     * @return {@link Class}<{@link NameResponse}>
     */
    @Override
    public Class<NameResponse> getResponseClass() {
        return NameResponse.class;
    }


    @Override
    public String getMethod() {
        return RequestMethodEnum.GET.getValue();
    }
}
