package com.lfs.client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: 西尾Ink
 * @Date: 2024/09/15 08:41:51
 * @Version: 1.0
 * @Description: qi api客户端
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiClient {
    /**
     * 访问密钥
     */
    private String accessKey;

    /**
     * 密钥
     */
    private String secretKey;

}
