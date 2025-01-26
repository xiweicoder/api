package com.lfs.model.request;

import com.lfs.model.enums.RequestMethodEnum;
import com.lfs.model.params.ChatParams;
import com.lfs.model.params.RandomWallpaperParams;
import com.lfs.model.response.ChatResponse;
import com.lfs.model.response.RandomWallpaperResponse;
import com.lfs.model.response.ResultResponse;
import lombok.experimental.Accessors;

/**
 * @Author: 西尾Ink
 * @Date: 2024年09月17日 08:38
 * @Version: 1.0
 * @Description:
 */
@Accessors(chain = true)
public class ChatRequest extends BaseRequest<ChatParams, ChatResponse> {
    @Override
    public String getPath() {
        return "/chat";
    }

    /**
     * 获取响应类
     *
     * @return {@link Class}<{@link ResultResponse}>
     */
    @Override
    public Class<ChatResponse> getResponseClass() {
        return ChatResponse.class;
    }

    @Override
    public String getMethod() {
        return RequestMethodEnum.GET.getValue();
    }
}
