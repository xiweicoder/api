package com.lfs.model.dto.productinfo;

import com.lfs.common.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @Author: 西尾ink
 * @Date: 2024/09/04 11:33:48
 * @Version: 1.0
 * @Description: 产品信息搜索文本请求
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ProductInfoSearchTextRequest extends PageRequest implements Serializable {
    private static final long serialVersionUID = -6337349622479990038L;

    private String searchText;
}
