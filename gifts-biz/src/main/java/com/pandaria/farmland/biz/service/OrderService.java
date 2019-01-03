package com.pandaria.farmland.biz.service;

import com.pandaria.farmland.biz.component.exception.RecordAlreadyExistsException;
import com.pandaria.farmland.biz.component.exception.RecordNotFoundException;
import com.pandaria.farmland.biz.entity.Order;
import com.pandaria.farmland.biz.mapper.OrderMapper;
import com.pandaria.farmland.biz.mapper.SequenceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.pandaria.farmland.biz.AppConstants.DOMAIN_ORDER_NAME;

@Service
public class OrderService {

    @Autowired
    private OrderMapper mapper;

    @Autowired
    private SequenceMapper sequenceMapper;

    public Order order(Order order) {
        if (order == null) {
            return null;
        }

        int id = sequenceMapper.getIdFor(DOMAIN_ORDER_NAME);
        order.setId(id);

        if(mapper.insert(order) > 0){
            return order;
        } else {
            throw new RecordAlreadyExistsException();
        }
    }

    public Order getOrderInfo(int id) {
        if (id <= 0) {
            throw new RecordNotFoundException();
        }
        Order order = mapper.query(id);
        if (order == null) {
            throw new RecordNotFoundException();
        }
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
