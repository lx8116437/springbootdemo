package com.example.demo.controller;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import com.example.demo.entity.UserInfo;
import com.example.demo.entity.ViewUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class HelloController {
    @Autowired
    private UserDao userDao;
    @RequestMapping("/hello")
    public String index(){
        return "hello";
    }

    @RequestMapping("save")
    public String saveUser(){
        User u = new User();
        u.setUserName("刘骁");
        u.setSex(1);
        u.setEmail("988988989@qq.com");
        userDao.save(u);
        return "1";
    }
    @RequestMapping("/getUser")
//    @Cacheable(value="user-key")
    public User getUser() {
        User user=userDao.findByUserName("刘骁");
        System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
        return user;
    }

    @RequestMapping("queryAll")
    public Page<User> findAllUser(){
        int page = 1;
        int pageSize = 5;
        List<String> list = new ArrayList<String>();
        list.add("id");
//        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable p = PageRequest.of(page,pageSize);
        return userDao.findAll(p);
    }

    @RequestMapping("updateById")
    public String updateById(){
        userDao.updateUser("刘骁1",1L);
        return "修改成功!";
    }

    @RequestMapping("delete")
    public String delete(){
        userDao.deleteByUserId(6L);
        return "删除成功!";
    }

    @RequestMapping("findByEmail")
    public User findByEmail(){
        User u = userDao.findByEmail("123131@qq.com");
        return u;
    }

    @RequestMapping("queryUser")
    public List<ViewUser> queryUser(){
//        ViewUser u = new ViewUser();
        List<ViewUser> u = userDao.queryViewUser();
        return u;
    }
}
