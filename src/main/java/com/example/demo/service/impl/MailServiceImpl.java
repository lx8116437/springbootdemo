package com.example.demo.service.impl;

import com.example.demo.service.MailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;


@Component
public class MailServiceImpl implements MailService {
    private final Logger logger = (Logger)LoggerFactory.getLogger(this.getClass());
    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${mail.fromMail.addr}")
    private String from;

    /**
     * 邮件服务的实现类
     * @param to 收件人邮箱
     * @param subject 标题
     * @param content 发送内容
     */
    @Override
    public void sendSimpleMail(String to, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setFrom(from);
        message.setSubject(subject);
        message.setText(content);

        try{
            javaMailSender.send(message);
            logger.info("简单邮件已经发送。");
        }catch (Exception e) {
            logger.error("发送简单邮件时发生异常！", e);
        }

    }
}
