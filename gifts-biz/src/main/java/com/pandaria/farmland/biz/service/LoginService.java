package com.pandaria.farmland.biz.service;

import static com.pandaria.farmland.biz.AppConstants.*;
import com.pandaria.farmland.biz.component.exception.RecordAlreadyExistsException;
import com.pandaria.farmland.biz.component.exception.RecordNotFoundException;
import com.pandaria.farmland.biz.entity.User;
import com.pandaria.farmland.biz.mapper.SequenceMapper;
import com.pandaria.farmland.biz.mapper.UserMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private SequenceMapper sequenceMapper;

    public User register(User user) {
        if (user == null) {
            return null;
        }
        int id = sequenceMapper.getIdFor(DOMAIN_USER_NAME);
        user.setId(id);

        if(userMapper.insert(user) > 0){
            return user;
        } else {
            throw new RecordAlreadyExistsException();
        }
    }

    public User getUserInfo(int id) {
        if (id <= 0) {
            throw new RecordNotFoundException();
        }
        User user = userMapper.query(id);
        return user;
    }

    public User getUserInfo(String weChatNumber) {
        if (StringUtils.isBlank(weChatNumber)) {
            throw new RecordNotFoundException();
        }
        User user = userMapper.queryByWeChatNumber(weChatNumber);
        return user;
    }

    public int updateUserInfo(User user) {
        if (user == null) {
            throw new RecordNotFoundException();
        }
        int result = userMapper.update(user);
        return result;
    }
}
