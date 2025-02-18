package com.lfs.model.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author: 西尾Ink
 * @Date: 2024年09月17日 08:38
 * @Version: 1.0
 * @Description:
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PoisonousChickenSoupResponse extends ResultResponse {
    private static final long serialVersionUID = -6467312483425078539L;
    private String text;
}
