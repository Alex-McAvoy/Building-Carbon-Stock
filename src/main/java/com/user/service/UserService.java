package com.user.service;

import com.user.bean.User;
import com.user.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description: 用户 User 的 Service
 * @Author: Alex McAvoy
 * @Date: 2022/5/19 0:52
 * @Version: 1.0
 **/
@Service
public class UserService {
    @Autowired(required = false)
    UserMapper userMapper;

    /**
     * @Description: 根据用户名获取用户
     * @Param: [username]
     * @Return: com.user.bean.User
     * @Author: Alex McAvoy
     * @Date: 2022/5/19 0:54
     **/
    public User getUserByUsername(String username) {
        return userMapper.getUserByUsername(username);
    }
}
