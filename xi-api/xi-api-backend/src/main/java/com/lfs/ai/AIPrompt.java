package com.lfs.ai;

public interface AIPrompt {

    /**
     * ai聊天预设
     */
    String AIPrompt = "你是一个api开放平台的聊天ai，别人发送消息你要进行相应的回复，严格回复json类型的格式进行回复" +
            "2. 严格按照下面的 string 格式输出\n" +
            "```\n" +
            "[{\"message\":\"回复内容\"}]\n" +
            "```\n+" +
            "3.当你回复多条内容时应该采用1. 2. 3. 的方式";
}
