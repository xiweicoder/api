package com.lfs.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lfs.model.entity.ProductInfo;

/**
 * @Author: 西尾ink
 * @Date: 2024/08/25 03:04:43
 * @Version: 1.0
 * @Description: 产品信息服务
 */
public interface ProductInfoService extends IService<ProductInfo> {
    /**
     * 有效产品信息
     * 校验
     *
     * @param add         是否为创建校验
     * @param productInfo 产品信息
     */
    void validProductInfo(ProductInfo productInfo, boolean add);
}
