package com.ecosphere.common.utils;

/**
 * @author qht
 * @date 2025/4/15
 */
// 生成验证码
public class CodeUtils {
    public static String generateCode(int length) {
        StringBuilder code = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int randomDigit = (int) (Math.random() * 10);
            code.append(randomDigit);
        }
        return code.toString();
    }
}