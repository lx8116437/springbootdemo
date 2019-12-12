package com.example.demo.entity;

public class ViewUser {
    private static final long serialVersionUID = 1L;

    private User user;
    private UserInfo userInfo;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
    public ViewUser() {

    }

    public ViewUser(User user, UserInfo userInfo){
        this.user = user;
        this.userInfo = userInfo;
    }
    public ViewUser(User user){
        UserInfo userInfo = new UserInfo();
        this.user = user;
        this.userInfo = userInfo;
    }
    public ViewUser(UserInfo userInfo){
        User user = new User();
        this.user = user;
        this.userInfo = userInfo;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    @Override
    public String toString() {
        return "ViewUser{" +
                "user=" + user +
                ", userInfo=" + userInfo +
                '}';
    }
}
