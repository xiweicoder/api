package com.lfs.model.params;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Author: 西尾Ink
 * @Date: 2024/09/22 09:04:24
 * @Version: 1.0
 * @Description: 获取ip地址请求参数
 */
@Data
@Accessors(chain = true)
public class IpInfoParams implements Serializable {
    private static final long serialVersionUID = 3815188540434269370L;
    private String ip;
}
