package com.lfs.model.dto.productorder;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: 西尾ink
 * @Date: 2024/08/23 03:22:17
 * @Version: 1.0
 * @Description: 创建请求
 */
@Data
public class ProductOrderAddRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 接口id
     */
    private String productId;

    /**
     * 支付类型
     */
    private String payType;

    /**
     * 订单号
     */
    private String orderNo;

}