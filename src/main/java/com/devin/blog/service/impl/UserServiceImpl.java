package com.devin.blog.service.impl;

import com.devin.blog.config.UserProperties;
import com.devin.blog.service.UserService;
import com.devin.blog.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserProperties userProperties;

    @Override
    public boolean checkUser(String username, String password) {
        String encryptPwd = MD5Utils.encrypt(password);
        return username.equals(userProperties.getUsername()) && encryptPwd.equals(userProperties.getPassword());
    }
}
