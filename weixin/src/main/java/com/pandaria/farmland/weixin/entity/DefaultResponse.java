package com.pandaria.farmland.weixin.entity;

public class DefaultResponse<T> {

    public DefaultResponse(){}

    public DefaultResponse(ResponseStatus responseStatus){
        this.returnCode = responseStatus.getCode();
        this.returnMessage = responseStatus.getMessage();
    }

    public DefaultResponse(ResponseStatus responseStatus, T data){
        this.returnCode = responseStatus.getCode();
        this.returnMessage = responseStatus.getMessage();
        this.data = data;
    }

    private int returnCode;

    private String returnMessage;

    private T data;

    public int getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(int returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMessage() {
        return returnMessage;
    }

    public void setReturnMessage(String returnMessage) {
        this.returnMessage = returnMessage;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
