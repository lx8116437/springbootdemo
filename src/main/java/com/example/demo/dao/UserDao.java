package com.example.demo.dao;


import com.example.demo.entity.User;
import com.example.demo.entity.ViewUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface UserDao extends JpaRepository<User, String> {
    User findByUserName(String userName);

    @Transactional
    @Modifying
    @Query("update User u set u.userName = ?1 where u.id = ?2")
    int updateUser(String  userName, Long id);

    @Transactional
    @Modifying
    @Query("delete from User where id = ?1")
    void deleteByUserId(Long id);

    @Transactional(timeout = 10)
    @Query("select u from User u where u.email = ?1")
    User findByEmail(String email);

    /**
     * 两表关联查询
     *
     * 这里的表名 不是数据库真实表名,是对应的实体类名字
     * User u,
     * UserInfo info
     *
     * 字段同理
     * where u.id = info.userId
     * @return
     */
    @Transactional
    @Query(value = "select new com.example.demo.entity.ViewUser(u,info) from User u,UserInfo info where u.id = info.userId")
    List<ViewUser> queryViewUser();
}
