package com.lfs.exception;

import lombok.Data;

/**
 * @Author: 西尾Ink
 * @Date: 2024年09月18日 21:52
 * @Version: 1.0
 * @Description:
 */
@Data
public class ErrorResponse {
    private String message;
    private int code;
}
