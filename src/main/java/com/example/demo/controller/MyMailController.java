package com.example.demo.controller;

import com.example.demo.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/mail")
public class MyMailController {
    @Autowired
    MailService mailService;

    @ResponseBody
    @RequestMapping("/sendMail")
    public String sendMail(){
        mailService.sendSimpleMail("xxx@163.com","标题!","邮件内容");
        return "发送成功!";
    }

}
