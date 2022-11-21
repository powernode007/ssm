package com.bjpn.bean;

import java.util.Objects;

public class User {
    private Integer userId;
    private String userName;
    private String userCode;
    private String userPwd;
    private String userPhoto;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId) &&
                Objects.equals(userName, user.userName) &&
                Objects.equals(userCode, user.userCode) &&
                Objects.equals(userPwd, user.userPwd) &&
                Objects.equals(userPhoto, user.userPhoto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userName, userCode, userPwd, userPhoto);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userCode='" + userCode + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", userPhoto='" + userPhoto + '\'' +
                '}';
    }

    public User(Integer userId, String userName, String userCode, String userPwd, String userPhoto) {
        this.userId = userId;
        this.userName = userName;
        this.userCode = userCode;
        this.userPwd = userPwd;
        this.userPhoto = userPhoto;
    }
    public User(){}
}
