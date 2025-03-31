package com.ecosphere.user.domain.vo;

import lombok.Data;

/**
 * @author qht
 * @date 2025/3/31
 */
@Data
public class UserLoginVo {
    /** 主键 */
    private String id;
    /** 用户名 */
    private String username;
    /** 登录密码 */
    private String password;
    /** 手机号 */
    private String phone;
    /** 邮箱 */
    private String email;
    /** 头像 */
    private String picture;
    // token
    private String token;


}