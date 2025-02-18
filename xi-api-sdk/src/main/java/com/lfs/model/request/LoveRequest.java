package com.lfs.model.request;

import com.lfs.model.enums.RequestMethodEnum;
import com.lfs.model.response.LoveResponse;
import com.lfs.model.response.NameResponse;
import lombok.experimental.Accessors;

/**
 * @Author: 西尾Ink
 * @Date: 2024年09月17日 08:38
 * @Version: 1.0
 * @Description: 随机情话
 */
@Accessors(chain = true)
public class LoveRequest extends BaseRequest<String, LoveResponse> {

    @Override
    public String getPath() {
        return "/loveTalk";
    }

    /**
     * 获取响应类
     *
     * @return {@link Class}<{@link NameResponse}>
     */
    @Override
    public Class<LoveResponse> getResponseClass() {
        return LoveResponse.class;
    }


    @Override
    public String getMethod() {
        return RequestMethodEnum.GET.getValue();
    }
}
