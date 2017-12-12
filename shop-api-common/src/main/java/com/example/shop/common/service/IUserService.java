package com.example.shop.common.service;

import com.example.shop.common.domain.User;

public interface IUserService {

    /**
     * 用户注册
     * @param userName
     * @return
     */
    Boolean isExist(String userName);

    /**
     * 用户登录
     * @param userName
     * @param password
     */
    User login(String userName, String password);

    String createToken(User user);
}
