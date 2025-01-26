package com.lfs.model.params;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Author: 西尾Ink
 * @Date: 2024/09/18 05:39:26
 * @Version: 1.0
 * @Description: 随机壁纸参数
 */
@Data
@Accessors(chain = true)
public class RandomWallpaperParams implements Serializable {
    private static final long serialVersionUID = 3815188540434269370L;
    private String lx;
    private String method;
}
