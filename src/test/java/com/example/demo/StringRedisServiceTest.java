package com.example.demo;

import com.example.demo.service.StringRedisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StringRedisServiceTest {
    @Autowired
    StringRedisService stringRedisService;

    @Test
    public void set() {
        stringRedisService.setString("name","张三");
    }

    @Test
    public void get(){
        System.out.println(stringRedisService.getString("name"));
    }
}
