package com.pandaria.farmland.biz.mapper;

import com.pandaria.farmland.biz.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    User query(@Param("id") int id);

    User queryByWeChatNumber(@Param("weChatNumber") String weChatNumber);

    int insert(User user);

    int update(User user);
}
