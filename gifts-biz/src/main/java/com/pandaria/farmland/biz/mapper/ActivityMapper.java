package com.pandaria.farmland.biz.mapper;

import com.pandaria.farmland.biz.entity.Activity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityMapper {

    Activity query(@Param("id") int id);

    int insert(Activity activity);

    int update(Activity activity);

    int updateAvailableOrderTaskNumber(Activity activity);
}
