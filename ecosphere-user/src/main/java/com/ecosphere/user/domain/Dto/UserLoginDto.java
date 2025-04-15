package com.ecosphere.user.domain.Dto;

import lombok.Data;

/**
 * @author qht
 * @date 2025/3/31
 */
@Data
public class UserLoginDto {
    private String email;
    private String password;
}