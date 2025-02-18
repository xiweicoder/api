package com.lfs.model.enums;

/**
 * @Author: 西尾Ink
 * @Date: 2024年09月17日 13:27
 * @Version: 1.0
 * @Description:
 */
public enum RequestMethodEnum {
    /**
     * GET请求
     */
    GET("GET", "GET"),
    POST("POST", "POST");
    private final String text;
    private final String value;

    RequestMethodEnum(String text, String value) {
        this.text = text;
        this.value = value;
    }

    public String getText() {
        return text;
    }

    public String getValue() {
        return value;
    }
}
