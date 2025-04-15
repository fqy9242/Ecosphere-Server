package com.ecosphere.common.utils;

import cn.hutool.core.io.resource.ClassPathResource;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.concurrent.TimeUnit;

/**
 * @author qht
 * @date 2025/4/15
 */
@Component
@RequiredArgsConstructor
public class SendEmailUtils {
    private final JavaMailSender javaMailSender;
    private final RedisTemplate<String, String> redisTemplate;
    @Value("${spring.mail.username}")
    private String sender;
    public void sendEmail(String title, String content, String receiver) throws Exception {
        try {
            // 创建一个邮件消息
            MimeMessage message = javaMailSender.createMimeMessage();
            // 创建 MimeMessageHelper
            MimeMessageHelper helper = new MimeMessageHelper(message, false);
            // 发件人邮箱和名称
            helper.setFrom(sender, "悦绿生态圈");
            // 收件人邮箱
            helper.setTo(receiver);
            // 邮件标题
            helper.setSubject(title);
            // 邮件正文，第二个参数表示是否是HTML正文
            helper.setText(content, true);
            // 发送
            javaMailSender.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void sendEmailCode(String email) throws Exception {
        // 生成6位验证码
        String code = CodeUtils.generateCode(6);
        ClassPathResource resource = new ClassPathResource("templates/sendMailCodeTemplate.html");
        String html = new String(Files.readAllBytes(resource.getFile().toPath()), StandardCharsets.UTF_8);
        // 发送邮件
        sendEmail("邮箱验证码", html.replace("{0}", code), email);
        // 将验证码存入redis
        redisTemplate.opsForValue().set(email, code, 3 * 60, TimeUnit.SECONDS);
    }
    public void sendRegisterSuccessMail(String  email, String username) throws Exception {
        ClassPathResource resource = new ClassPathResource("templates/sendRegisterSuccessMail.html");
        String html = new String(Files.readAllBytes(resource.getFile().toPath()), StandardCharsets.UTF_8);
        // 发送邮件
        sendEmail("注册成功！", html.replace("{username}", username), email);
    }


}