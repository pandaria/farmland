package com.pandaria.farmland.biz.controller;

import com.pandaria.farmland.biz.entity.User;
import com.pandaria.farmland.biz.service.LoginService;
import com.pandaria.farmland.weixin.entity.DefaultResponse;
import com.pandaria.farmland.weixin.entity.ResponseStatus;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Api("用户登录注册接口")
@RequestMapping("/user")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/register/v1", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    @ApiOperation(value = "用户注册接口", notes = "用户提交注册页面接口，将填写用户信息保存")
    public @ResponseBody DefaultResponse<User> register(@RequestBody User user) {
        DefaultResponse<User> response = null;
        if (user == null) {
            response = new DefaultResponse<User>(ResponseStatus.FAILURE, null);
        } else {
            response = new DefaultResponse<User>(ResponseStatus.SUCCESS, loginService.register(user));
        }
        return response;
    }

    @RequestMapping(value = "/login/{id}/v1", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    @ApiOperation(value = "用户登录接口", notes = "验证用户身份，已注册用户返回用户信息，未注册用户返回空值")
    public @ResponseBody DefaultResponse<User> queryUserInfo(@PathVariable("id") int id) {
        DefaultResponse<User> response = null;
        if (id < 1) {
            response = new DefaultResponse<User>(ResponseStatus.FAILURE, null);
        } else {
            response = new DefaultResponse<User>(ResponseStatus.SUCCESS, loginService.getUserInfo(id));
        }
        return response;
    }

    @RequestMapping(value = "/update/v1", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    @ApiOperation(value = "用户信息更新接口", notes = "用户在个人信息修改页面修改提交后保存更新后的用户信息")
    public @ResponseBody DefaultResponse<User> updateUserInfo(@RequestBody User user) {
        DefaultResponse<User> response = null;
        if (user != null && loginService.updateUserInfo(user) > 0) {
            response = new DefaultResponse<User>(ResponseStatus.SUCCESS, null);
        } else if (user == null) {
            response = new DefaultResponse<User>(ResponseStatus.FAILURE, null);
        }
        return response;
    }
}
