package com.pandaria.farmland.biz.mapper;

import com.pandaria.farmland.biz.entity.Customer;
import com.pandaria.farmland.biz.entity.Order;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderMapper {

    Order query(@Param("id") int id);

    int insert(Order order);

    int update(Order order);
}
