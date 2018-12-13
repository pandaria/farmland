package com.pandaria.farmland.weixin.controller;

import com.pandaria.farmland.biz.entity.User;
import com.pandaria.farmland.biz.service.LoginService;
import com.pandaria.farmland.weixin.entity.DefaultResponse;
import com.pandaria.farmland.weixin.entity.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    public DefaultResponse<User> register(User user) {
        DefaultResponse<User> response = null;
        if (user == null) {
            response = new DefaultResponse<User>(ResponseStatus.FAILURE, null);
        } else {
            response = new DefaultResponse<>(ResponseStatus.SUCCESS, loginService.register(user));
        }
        return response;
    }
}
