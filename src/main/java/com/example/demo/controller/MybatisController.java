package com.example.demo.controller;

import com.example.demo.dao.MybatisUserDao;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MybatisController {

    @Autowired
    private MybatisUserDao dao;
    @RequestMapping("/myQueryAll")
    public List<User> queryAll(){
        return dao.getAll();
    }

    @RequestMapping("/myQueryOne")
    public User getOne(){
        return dao.getOne(1L);
    }

    @RequestMapping("/mySave")
    public String save(){
        User u = new User();
        u.setEmail("新增email");
        u.setUserName("刘骁2");
        u.setSex(1);
        u.setId(10L);
        dao.insert(u);
        return "";
    }

    @RequestMapping("/myUpdate")
    public String update(){
        User u = new User();
        u.setId(1L);
        u.setEmail("随便写的email");
        u.setUserName("刘骁1");
        dao.update(u);
        return "";
    }

    @RequestMapping("/myDelete")
    public String delete(Long id){
        dao.delete(id);
        return "";
    }

}
