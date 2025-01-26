package com.lfs.model.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author: 西尾Ink
 * @Date: 2024年09月17日 16:31
 * @Version: 1.0
 * @Description:
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ChatResponse extends ResultResponse {
    private static final long serialVersionUID = -6467312483425078539L;
    private String message;
}
