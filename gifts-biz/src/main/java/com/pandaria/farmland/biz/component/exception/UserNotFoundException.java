package com.pandaria.farmland.biz.component.exception;

public class UserNotFoundException extends RuntimeException {
    @Override
    public String getMessage() {
        return "用户不存在，请注册!";
    }
}
