package com.lfs.utils;

import cn.hutool.crypto.digest.MD5;
import cn.hutool.json.JSONUtil;

/**
 * @Author: 西尾Ink
 * @Date: 2024年08月16日 12:22
 * @Version: 1.0
 * @Description:
 */
public class SignUtils {
    public static String getSign(String body, String secretKey) {
        return MD5.create().digestHex(JSONUtil.toJsonStr(body) + '.' + secretKey);
    }
}
