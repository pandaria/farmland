package com.pandaria.farmland.biz.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SequenceMapper {

    int getIdFor(@Param("tableName")String tableName);
}
