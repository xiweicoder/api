package com.lfs.model.request;

import com.lfs.model.params.PoisonousChickenSoupParams;
import com.lfs.model.enums.RequestMethodEnum;
import com.lfs.model.response.PoisonousChickenSoupResponse;
import lombok.experimental.Accessors;

/**
 * @Author: 西尾Ink
 * @Date: 2024年09月17日 08:38
 * @Version: 1.0
 * @Description:
 */
@Accessors(chain = true)
public class PoisonousChickenSoupRequest extends BaseRequest<PoisonousChickenSoupParams, PoisonousChickenSoupResponse> {

    @Override
    public String getPath() {
        return "/poisonousChickenSoup";
    }

    /**
     * 获取响应类
     *
     * @return {@link Class}<{@link PoisonousChickenSoupResponse}>
     */
    @Override
    public Class<PoisonousChickenSoupResponse> getResponseClass() {
        return PoisonousChickenSoupResponse.class;
    }

    @Override
    public String getMethod() {
        return RequestMethodEnum.GET.getValue();
    }
}
