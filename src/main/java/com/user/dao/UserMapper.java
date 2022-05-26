package com.user.dao;

import com.user.bean.User;

/**
 * @Description: 用户 User 的 Dao 接口
 * @Author: Alex McAvoy
 * @Date: 2022/5/18 23:35
 **/
public interface UserMapper {
    public User getUserByUsername(String username); //根据用户名获取用户
}