package com.example.demo.service;

public interface MailService {
    public void sendSimpleMail(String to, String subject, String content);
    public void sendHtmlMail(String to, String subject, String content);

    void sendAttachmentsMail(String to, String subject, String content, String filePath);
    void sendInlineResourceMail(String to, String subject, String content, String rscPath, String rscId);
}
