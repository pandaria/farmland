package com.pandaria.farmland.biz.entity;

public class User {

    private int id;

    private String nickName;

    private int age;

    private String contactNumber;

    private String weChatNumber;

    private String taoBaoNumber;

    private int naughtyValue;

    private int creditValue;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getWeChatNumber() {
        return weChatNumber;
    }

    public void setWeChatNumber(String weChatNumber) {
        this.weChatNumber = weChatNumber;
    }

    public String getTaoBaoNumber() {
        return taoBaoNumber;
    }

    public void setTaoBaoNumber(String taoBaoNumber) {
        this.taoBaoNumber = taoBaoNumber;
    }

    public int getNaughtyValue() {
        return naughtyValue;
    }

    public void setNaughtyValue(int naughtyValue) {
        this.naughtyValue = naughtyValue;
    }

    public int getCreditValue() {
        return creditValue;
    }

    public void setCreditValue(int creditValue) {
        this.creditValue = creditValue;
    }
}
