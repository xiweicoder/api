package com.lfs.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lfs.qiapicommon.model.entity.InterfaceInfo;


/**
 * @Author: 西尾ink
 * @Date: 2024/09/15 09:32:11
 * @Version: 1.0
 * @Description: 接口信息服务
 */
public interface InterfaceInfoService extends IService<InterfaceInfo> {

    /**
     * 校验
     *
     * @param add           是否为创建校验
     * @param interfaceInfo 接口信息
     */
    void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add);

    /**
     * 更新总调用数
     *
     * @param interfaceId 接口id
     * @return boolean
     */
    boolean updateTotalInvokes(long interfaceId);
}
