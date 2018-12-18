package com.pandaria.farmland.biz.component.exception;

public class UserAlreadyExistsException extends RuntimeException {
    @Override
    public String getMessage() {
        return "淘宝账号或微信账号信息已被注册，请更新其他账号重试！";
    }
}
