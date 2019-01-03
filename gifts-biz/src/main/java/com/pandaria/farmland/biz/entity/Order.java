package com.pandaria.farmland.biz.entity;

import com.pandaria.farmland.toolkits.utils.JsonUtil;

public class Order {

    private int id;

    private Customer customer;

    private String description;

    private int taskNumber;

    private String processImageUrl;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTaskNumber() {
        return taskNumber;
    }

    public void setTaskNumber(int taskNumber) {
        this.taskNumber = taskNumber;
    }

    public String getProcessImageUrl() {
        return processImageUrl;
    }

    public void setProcessImageUrl(String processImageUrl) {
        this.processImageUrl = processImageUrl;
    }

    @Override
    public String toString() {
        return JsonUtil.objectToString(this);
    }
}
