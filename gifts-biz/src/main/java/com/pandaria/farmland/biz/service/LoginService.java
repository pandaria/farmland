package com.pandaria.farmland.biz.service;

import com.pandaria.farmland.biz.component.SpringUtil;
import com.pandaria.farmland.biz.component.exception.UserAlreadyExistsException;
import com.pandaria.farmland.biz.component.exception.UserNotFoundException;
import com.pandaria.farmland.biz.entity.User;
import com.pandaria.farmland.biz.mapper.UserMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private UserMapper userMapper;

    public User register(User user) {
        if (user == null) {
            return null;
        }


        if(userMapper.insert(user) > 0){
            return user;
        } else {
            throw new UserAlreadyExistsException();
        }
    }

    public User getUserInfo(int id) {
        if (id <= 0) {
            throw new UserNotFoundException();
        }
        User user = userMapper.query(id);
        return user;
    }

    public User getUserInfo(String weChatNumber) {
        if (StringUtils.isBlank(weChatNumber)) {
            throw new UserNotFoundException();
        }
        User user = userMapper.queryByWeChatNumber(weChatNumber);
        return user;
    }

    public int updateUserInfo(User user) {
        if (user == null) {
            throw new UserNotFoundException();
        }
        int result = userMapper.update(user);
        return result;
    }
}
