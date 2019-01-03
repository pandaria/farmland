package com.pandaria.farmland.biz.controller;

import com.pandaria.farmland.biz.entity.Customer;
import com.pandaria.farmland.biz.service.CustomerService;
import com.pandaria.farmland.biz.service.LoginService;
import com.pandaria.farmland.weixin.entity.DefaultResponse;
import com.pandaria.farmland.weixin.entity.ResponseStatus;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Api("客户登录注册接口")
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @RequestMapping(value = "/register/v1", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    @ApiOperation(value = "客户注册接口", notes = "客户提交注册页面接口，将填写客户信息保存")
    public @ResponseBody DefaultResponse<Customer> register(@RequestBody Customer customer) {
        DefaultResponse<Customer> response = null;
        if (customer == null) {
            response = new DefaultResponse<Customer>(ResponseStatus.FAILURE, null);
        } else {
            response = new DefaultResponse<>(ResponseStatus.SUCCESS, service.register(customer));
        }
        return response;
    }

    @RequestMapping(value = "/{id}/v1", method = {RequestMethod.POST, RequestMethod.GET}, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    @ApiOperation(value = "客户登录接口", notes = "验证客户身份，已注册客户返回客户信息，未注册客户返回空值")
    public @ResponseBody DefaultResponse<Customer> queryCustomerInfo(@PathVariable("id") int id) {
        DefaultResponse<Customer> response = null;
        if (id < 0) {
            response = new DefaultResponse<Customer>(ResponseStatus.FAILURE, null);
        } else {
            response = new DefaultResponse<>(ResponseStatus.SUCCESS, service.getCustomerInfo(id));
        }
        return response;
    }

    @RequestMapping(value = "/update/v1", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    @ApiOperation(value = "客户信息更新接口", notes = "客户在个人信息修改页面修改提交后保存更新后的客户信息")
    public @ResponseBody DefaultResponse<Customer> updateCustomerInfo(@RequestBody Customer customer) {
        DefaultResponse<Customer> response = null;
        if (customer != null && service.updateCustomerInfo(customer) > 0) {
            response = new DefaultResponse<Customer>(ResponseStatus.SUCCESS, null);
        } else if (customer == null) {
            response = new DefaultResponse<Customer>(ResponseStatus.FAILURE, null);
        }
        return response;
    }
}
