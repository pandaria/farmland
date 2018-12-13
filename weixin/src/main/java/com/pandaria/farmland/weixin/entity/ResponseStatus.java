package com.pandaria.farmland.weixin.entity;

public enum ResponseStatus {
    SUCCESS(0, "SUCCESS"), FAILURE(1, "FAILURE");
    int code;
    String message;

    ResponseStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }


    public String getMessage() {
        return message;
    }

}
