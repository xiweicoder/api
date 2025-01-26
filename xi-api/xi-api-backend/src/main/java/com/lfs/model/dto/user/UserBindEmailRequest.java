package com.lfs.model.dto.user;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: 西尾ink
 * @Date: 2024/09/10 10:33:34
 * @Version: 1.0
 * @Description: 用户绑定电子邮件请求
 */
@Data
public class UserBindEmailRequest implements Serializable {

    private static final long serialVersionUID = 3191241716373120793L;

    private String emailAccount;

    private String captcha;
}
