package com.pandaria.farmland.biz.entity;

import com.pandaria.farmland.toolkits.utils.JsonUtil;

public class Customer {

    private int id;

    private String shopName;

    private String shopId;

    private String phoneNumber;

    private int creditValue;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getCreditValue() {
        return creditValue;
    }

    public void setCreditValue(int creditValue) {
        this.creditValue = creditValue;
    }

    @Override
    public String toString() {
        return JsonUtil.objectToString(this);
    }
}
