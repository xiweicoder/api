package com.lfs.exception;

import com.lfs.common.ErrorCode;

/**
 * @Author: 西尾ink
 * @Date: 2024/09/15 09:31:43
 * @Version: 1.0
 * @Description: 自定义异常类
 */
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 2942420535500634982L;
    private final int code;

    public BusinessException(int code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.code = errorCode.getCode();
    }

    public BusinessException(ErrorCode errorCode, String message) {
        super(message);
        this.code = errorCode.getCode();
    }

    public int getCode() {
        return code;
    }
}
