package com.ecosphere.user.domain.Dto;

import lombok.Data;

/**
 * @author qht
 * @date 2025/4/2
 */
@Data
public class UserRegisterDto {
    private String username;
    private String password;
    private String email;
    private String code;
}