package com.example.demo.dao;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MybatisUserDao {
    @Select("SELECT * FROM User")
    List<User> getAll();

    @Select("SELECT * FROM User WHERE id = #{id}")
    User getOne(Long id);

    @Insert("INSERT INTO User(id,user_name,sex,email) VALUES(#{id}, #{userName}, #{sex}, #{email})")
    void insert(User user);

    @Update("UPDATE User SET user_Name=#{userName},email=#{email} WHERE id =#{id}")
    void update(User user);

    @Delete("DELETE FROM User WHERE id =#{id}")
    void delete(Long id);
}
