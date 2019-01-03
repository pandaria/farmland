package com.pandaria.farmland.biz.service;

import com.pandaria.farmland.biz.component.exception.MandatoryFieldMissingException;
import com.pandaria.farmland.biz.component.exception.RecordAlreadyExistsException;
import com.pandaria.farmland.biz.component.exception.RecordNotFoundException;
import com.pandaria.farmland.biz.entity.Customer;
import com.pandaria.farmland.biz.mapper.CustomerMapper;
import com.pandaria.farmland.biz.mapper.SequenceMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.pandaria.farmland.biz.AppConstants.DOMAIN_CUSTOMER_NAME;

@Service
public class CustomerService {

    @Autowired
    private CustomerMapper mapper;

    @Autowired
    private SequenceMapper sequenceMapper;

    public Customer register(Customer customer) {
        if (customer == null) {
            return null;
        }

        String shopName = customer.getShopName();
        if (StringUtils.isNotBlank(shopName)) {
            customer.setShopName(shopName.trim());
            Customer tempCustomer = mapper.queryByShopName(customer.getShopName());
            if(tempCustomer != null) {
                throw new RecordAlreadyExistsException();
            } else {
                int id = sequenceMapper.getIdFor(DOMAIN_CUSTOMER_NAME);
                customer.setId(id);
                if (mapper.insert(customer) > 0) {
                    return customer;
                } else {
                    throw new RecordNotFoundException();
                }
            }
        } else {
            throw new MandatoryFieldMissingException("店铺名称");
        }
    }

    public Customer getCustomerInfo(int id) {
        if (id <= 0) {
            throw new RecordNotFoundException();
        }
        Customer customer = mapper.query(id);
        return customer;
    }

    public Customer getCustomerInfo(String shopName) {
        if (StringUtils.isBlank(shopName)) {
            throw new RecordNotFoundException();
        }
        Customer customer = mapper.queryByShopName(shopName);
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
