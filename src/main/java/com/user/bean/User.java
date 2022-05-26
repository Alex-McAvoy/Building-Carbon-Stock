package com.user.bean;

/**
 * @Description: 用户
 * @Author: Alex McAvoy
 * @Date: 2022/5/18 23:34
 **/
public class User {
    private Integer id; //用户id，主键
    private String username; //用户名
    private String password; //密码
    private Integer authority; //权限

    public User() {
    }

    public User(Integer id, String username, String password, Integer authority) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.authority = authority;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getAuthority() {
        return authority;
    }

    public void setAuthority(Integer authority) {
        this.authority = authority;
    }

    @Override
    public String toString() {
        return  "{id:" + id +
                ", username:'" + username + '\'' +
                ", password:'" + password + '\'' +
                ", authority:" + authority +
                '}';
    }
}