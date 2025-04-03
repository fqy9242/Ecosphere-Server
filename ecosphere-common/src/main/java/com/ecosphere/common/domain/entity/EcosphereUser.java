package com.ecosphere.common.domain.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ecosphere.common.annotation.Excel;
import com.ecosphere.common.core.domain.BaseEntity;

/**
 * 注册用户对象 ecosphere_user
 * 
 * @author qht
 * @date 2025-03-19
 */
@TableName("ecosphere_user")
@Data
public class EcosphereUser extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private String id;

    /** 用户名 */
    @Excel(name = "用户名")
    private String username;

    /** 登录密码 */
    private String password;

    /** 手机号 */
    @Excel(name = "手机号")
    private String phone;

    /** 邮箱 */
    @Excel(name = "邮箱")
    private String email;

    /** 头像 */
    @Excel(name = "头像")
    private String picture;

    /** 用户状态 */
    @Excel(name = "用户状态")
    private Integer userStatus;

    /** 上次登录 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "上次登录", width = 30, dateFormat = "yyyy-MM-dd")
    private Date lastLoginTime;

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("username", getUsername())
            .append("password", getPassword())
            .append("phone", getPhone())
            .append("email", getEmail())
            .append("picture", getPicture())
            .append("userStatus", getUserStatus())
            .append("lastLoginTime", getLastLoginTime())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
