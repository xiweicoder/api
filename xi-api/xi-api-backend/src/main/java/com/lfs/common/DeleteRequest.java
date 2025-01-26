package com.lfs.common;

import lombok.Data;

import java.io.Serializable;

/**
 * 删除请求
 *
 * @author 西尾Ink
 */
@Data
public class DeleteRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * id
     */
    private Long id;
}