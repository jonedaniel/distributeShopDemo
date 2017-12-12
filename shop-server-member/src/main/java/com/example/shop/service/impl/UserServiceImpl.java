package com.example.shop.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.example.shop.common.domain.User;
import com.example.shop.common.service.IUserService;
import com.example.shop.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class UserServiceImpl implements IUserService {

    private static Map<String, Object> userCache = new ConcurrentHashMap<>();

    @Autowired
    UserMapper userMapper;

    @Override
    public Boolean isExist(String userName) {
        User user = userMapper.selectByUsername(userName);
        if (user == null) {
            return false;
        }
        return true;
    }

    @Override
    public User login(String userName, String password) {
        User user = userMapper.login(userName, password);
        return user;
    }

    @Override
    public String createToken(User user) {
        String token = UUID.randomUUID().toString().substring(0, 4);
        userCache.put(token,user);
        return token;
    }
}
