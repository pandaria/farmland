package com.pandaria.farmland.biz.mapper;

import com.pandaria.farmland.biz.entity.Task;
import com.pandaria.farmland.biz.entity.Customer;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskMapper {

    Task query(@Param("id") int id);

    int insert(Task task);

    int update(Task task);

    int updateStatusCode(Task task);
}
