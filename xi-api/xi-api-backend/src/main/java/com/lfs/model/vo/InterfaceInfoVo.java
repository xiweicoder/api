package com.lfs.model.vo;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.lfs.qiapicommon.model.entity.InterfaceInfo;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: 西尾ink
 * @Date: 2024年08月21日 18:54
 * @Version: 1.0
 * @Description:
 */
@Data
public class InterfaceInfoVo implements Serializable {
    private static final long serialVersionUID = 5713565919036400439L;
    private List<InterfaceInfo> records;
    private long total;
    private long size;
    private long current;
    private List<OrderItem> orders;
    private boolean optimizeCountSql;
    private boolean searchCount;
    private boolean optimizeJoinOfCountSql;
    private String countId;
    private Long maxLimit;
}
