package com.lfs.service.inner.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.lfs.manager.AiManager;
import com.lfs.qiapicommon.service.inner.AIChatService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

import static com.lfs.ai.AIPrompt.AIPrompt;

@DubboService
@Slf4j
public class AIChatServiceImpl implements AIChatService {
    @Resource
    private AiManager aiManager;

    /**
     * ai聊天接口
     *
     * @param message
     * @return
     */
    @Override
    public String chat(String message) {
        if (BeanUtil.isEmpty(message)) {
            return "发送消息为空";
        }
        String result = aiManager.doSyncRequest(AIPrompt.AIPrompt, message, null);
        int start = result.indexOf("[");
        int end = result.lastIndexOf("]");
        String json = result.substring(start, end + 1);
        List<String> jsonObjects = new ArrayList<>();
        JSONArray jsonArray = JSONUtil.parseArray(json);
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            String messageStr = jsonObject.getStr("message");
            jsonObjects.add(messageStr);
        }
        // 从 JSONObject 中提取 "message" 字段的值
        String resultString = String.join("", jsonObjects);
        return resultString;
    }
}
