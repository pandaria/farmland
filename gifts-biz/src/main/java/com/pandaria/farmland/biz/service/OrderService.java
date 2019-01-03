package com.pandaria.farmland.biz.service;

import com.pandaria.farmland.biz.component.exception.MandatoryFieldMissingException;
import com.pandaria.farmland.biz.component.exception.RecordAlreadyExistsException;
import com.pandaria.farmland.biz.component.exception.RecordNotFoundException;
import com.pandaria.farmland.biz.entity.Order;
import com.pandaria.farmland.biz.mapper.OrderMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderMapper mapper;

    public Order order(Order order) {
        if (order == null) {
            return null;
        }

        String orderName = order.getOrderName();
        if (StringUtils.isNotBlank(orderName)) {
            order.setOrderName(orderName.trim());
            Order tempOrder = mapper.queryByOrderName(orderName.trim());
            if(tempOrder != null) {
                order = tempOrder;
            } else {
                if(mapper.insert(order) > 0){
                    order = mapper.queryByOrderName(orderName.trim());
                } else {
                    throw new RecordAlreadyExistsException();
                }
            }
            return order;

        } else {
            throw new MandatoryFieldMissingException("订单名称");
        }
    }

    public Order getOrderInfo(int id) {
        if (id <= 0) {
            throw new RecordNotFoundException();
        }
        Order order = mapper.query(id);
        return order;
    }

    public Order getOrderInfo(String orderName) {
        if (StringUtils.isBlank(orderName)) {
            throw new RecordNotFoundException();
        }
        Order order = mapper.queryByOrderName(orderName);
        return order;
    }

    public int updateOrderInfo(Order order) {
        if (order == null) {
            throw new RecordNotFoundException();
        }
        int result = mapper.update(order);
        return result;
    }
}
