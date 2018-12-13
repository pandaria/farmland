package com.pandaria.farmland.weixin.controller;

import com.pandaria.farmland.biz.entity.User;
import com.pandaria.farmland.biz.service.LoginService;
import com.pandaria.farmland.weixin.entity.DefaultResponse;
import com.pandaria.farmland.weixin.entity.ResponseStatus;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Api("用户登录注册接口")
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "execute", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ApiOperation(value = "注册接口", notes = "用户提交注册页面接口")
    public @ResponseBody DefaultResponse<User> register(@RequestBody User user) {
        DefaultResponse<User> response = null;
        if (user == null) {
            response = new DefaultResponse<User>(ResponseStatus.FAILURE, null);
        } else {
            response = new DefaultResponse<>(ResponseStatus.SUCCESS, loginService.register(user));
        }
        return response;
    }
}
