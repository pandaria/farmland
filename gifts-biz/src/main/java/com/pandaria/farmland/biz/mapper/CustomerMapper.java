package com.pandaria.farmland.biz.mapper;

import com.pandaria.farmland.biz.entity.Customer;
import com.pandaria.farmland.biz.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerMapper {

    Customer query(@Param("id") int id);

    Customer queryByShopId(@Param("shopId") String shopId);

    int insert(Customer user);

    int update(Customer user);

    int updateCreditValue(Customer user);
}
