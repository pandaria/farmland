package com.pandaria.farmland.biz.controller;

import com.pandaria.farmland.biz.entity.Order;
import com.pandaria.farmland.biz.service.OrderService;
import com.pandaria.farmland.weixin.entity.DefaultResponse;
import com.pandaria.farmland.weixin.entity.ResponseStatus;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Api("订单管理接口")
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService service;

    @RequestMapping(value = "/v1", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    @ApiOperation(value = "订单生成接口", notes = "订单提交管理页面接口，将填写订单信息保存")
    public @ResponseBody DefaultResponse<Order> order(@RequestBody Order order) {
        DefaultResponse<Order> response = null;
        if (order == null) {
            response = new DefaultResponse<Order>(ResponseStatus.FAILURE, null);
        } else {
            response = new DefaultResponse<Order>(ResponseStatus.SUCCESS, service.order(order));
        }
        return response;
    }

    @RequestMapping(value = "/{id}/v1", method = {RequestMethod.POST, RequestMethod.GET}, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    @ApiOperation(value = "订单查询接口", notes = "查询订单详细信息，返回已登记订单信息")
    public @ResponseBody DefaultResponse<Order> queryOrderInfo(@PathVariable("id") int id) {
        DefaultResponse<Order> response = null;
        if (id < 0) {
            response = new DefaultResponse<Order>(ResponseStatus.FAILURE, null);
        } else {
            response = new DefaultResponse<>(ResponseStatus.SUCCESS, service.getOrderInfo(id));
        }
        return response;
    }

    @RequestMapping(value = "/update/v1", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    @ApiOperation(value = "订单信息更新接口", notes = "订单在订单修改页面提交后保存更新后的订单信息")
    public @ResponseBody DefaultResponse<Order> updateOrderInfo(@RequestBody Order order) {
        DefaultResponse<Order> response = null;
        if (order != null && service.updateOrderInfo(order) > 0) {
            response = new DefaultResponse<Order>(ResponseStatus.SUCCESS, order);
        } else if (order == null) {
            response = new DefaultResponse<Order>(ResponseStatus.FAILURE, null);
        }
        return response;
    }
}
