package com.lfs.model.params;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Author: 西尾Ink
 * @Date: 2024年09月18日 12:37
 * @Version: 1.0
 * @Description: ai聊天
 */
@Data
@Accessors(chain = true)
public class ChatParams implements Serializable {
    private static final long serialVersionUID = 3815188540434269370L;
    private String message;
}
