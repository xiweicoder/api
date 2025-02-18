package com.lfs.model.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author: 西尾Ink
 * @Date: 2024年09月19日 11:26
 * @Version: 1.0
 * @Description:
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class NameResponse extends ResultResponse {
    private static final long serialVersionUID = -1038984103811824271L;
    private String name;
}
