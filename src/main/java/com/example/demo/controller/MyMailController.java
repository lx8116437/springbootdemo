package com.example.demo.controller;

import com.example.demo.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/mail")
public class MyMailController {
    @Autowired
    MailService mailService;
    @Autowired
    TemplateEngine templateEngine;


    @ResponseBody
    @RequestMapping("/sendMail")
    public String sendMail(){
        mailService.sendSimpleMail("lx8116437@163.com","标题!","邮件内容");
        return "发送成功!";
    }

    @ResponseBody
    @RequestMapping("/sendMail1")
    public String sendMail1(){
        String content = "<html><body><h3>hello world ! 这是一封Html邮件!</h3></body></html>";
        mailService.sendHtmlMail("lx8116437@163.com", "html", content);
        return "发送成功!";
    }

    @ResponseBody
    @RequestMapping("/sendAttachmentsMail")
    public String sendAttachmentsMail(){
        String file = "E:\\test.txt";
        mailService.sendAttachmentsMail("lx8116437@163.com", "带附件的邮件", "内容",file);
        return "发送成功!";
    }

    @ResponseBody
    @RequestMapping("/sendInlineResourceMail")
    public String sendInlineResourceMail(){
        String rscId = "neo006";
        String content = "<html><body>这是有图片的邮件：<img src=\'cid:" + rscId +"\' ></body></html>";
        String imgPath = "D:\\11.png";
        mailService.sendInlineResourceMail("lx8116437@163.com", "带附件的邮件", content,imgPath,rscId);
        return "发送成功!";
    }


    @ResponseBody
    @RequestMapping("/sendTemplateMail")
    public String sendTemplateMail(){
        Context context = new Context();
        Map<String,Object> map = new HashMap<>();
        map.put("id","003");
        context.setVariables(map);

        String emailContent = templateEngine.process("emailTemplate", context);

        mailService.sendHtmlMail("lx8116437@163.com", "主题：这是模板邮件", emailContent);
        return "发送成功!";
    }




}
