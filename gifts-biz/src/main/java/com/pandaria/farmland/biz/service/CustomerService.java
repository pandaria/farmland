package com.pandaria.farmland.biz.service;

import com.pandaria.farmland.biz.component.exception.MandatoryFieldMissingException;
import com.pandaria.farmland.biz.component.exception.RecordAlreadyExistsException;
import com.pandaria.farmland.biz.component.exception.RecordNotFoundException;
import com.pandaria.farmland.biz.entity.Customer;
import com.pandaria.farmland.biz.mapper.CustomerMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerMapper mapper;

    public Customer register(Customer customer) {
        if (customer == null) {
            return null;
        }

        String shopId = customer.getShopId();
        if (StringUtils.isNotBlank(shopId)) {
            customer.setShopId(shopId.trim());
            Customer tempCustomer = mapper.queryByShopId(shopId.trim());
            if(tempCustomer != null) {
                customer = tempCustomer;
            } else {
                if(mapper.insert(customer) > 0){
                    customer = mapper.queryByShopId(shopId.trim());
                } else {
                    throw new RecordAlreadyExistsException();
                }
            }
            return customer;

        } else {
            throw new MandatoryFieldMissingException("淘宝店铺id");
        }
    }

    public Customer getCustomerInfo(int id) {
        if (id <= 0) {
            throw new RecordNotFoundException();
        }
        Customer customer = mapper.query(id);
        return customer;
    }

    public Customer getCustomerInfo(String shopId) {
        if (StringUtils.isBlank(shopId)) {
            throw new RecordNotFoundException();
        }
        Customer customer = mapper.queryByShopId(shopId);
        return customer;
    }

    public int updateCustomerInfo(Customer customer) {
        if (customer == null) {
            throw new RecordNotFoundException();
        }
        int result = mapper.update(customer);
        return result;
    }
}
