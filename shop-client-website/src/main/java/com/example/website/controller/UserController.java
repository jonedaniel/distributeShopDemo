package com.example.website.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.example.shop.common.domain.User;
import com.example.shop.common.service.IUserService;
import com.example.shop.common.vo.JsonResult;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Reference
    IUserService userService;

    /**
     * 用户注册的接口
     * @param user
     * @return
     */
    @RequestMapping(value = "/register",method = RequestMethod.POST,consumes = "application/x-www-form-urlencoded")
    public JsonResult register(User user) {
        JsonResult jsonResult = new JsonResult();
        System.out.println(user.getUserName());
        Boolean    exist      = userService.isExist(user.getUserName());
        if (exist) {
            jsonResult.setMsg("此用户已存在");
        }
        return jsonResult;
    }


    /**
     * 用户登录
     * POST /user/token 返回token字符串
     * @return
     */
    @RequestMapping(value = "/token",method = RequestMethod.POST,consumes = "application/x-www-form-urlencoded")
    public JsonResult login(String userName,String password) {
        JsonResult jsonResult = new JsonResult();
        User       user = userService.login(userName, password);
        if (user == null) {
            jsonResult.mark("登陆失败");
            return jsonResult;
        }
        String token = userService.createToken(user);
        jsonResult.setMsg(token);
        return jsonResult;
    }

    /**
     * 退出:删除token
     * DELETE /user/token
     */
    @RequestMapping(value = "/token",method = RequestMethod.DELETE)
    public JsonResult logout(@RequestHeader("token_in_header") String token) {
        JsonResult jsonResult = new JsonResult();
        System.out.println(token);
        return jsonResult;
    }
}
