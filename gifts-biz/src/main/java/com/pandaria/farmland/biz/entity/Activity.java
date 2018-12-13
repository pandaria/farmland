package com.pandaria.farmland.biz.entity;

import java.util.Date;

public class Activity {

    private int id;

    private String description;

    private Order order;

    private String rewardImageUrl;

    private Date startTime;

    private Date endTime;

    private int availableOrderTaskNumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getRewardImageUrl() {
        return rewardImageUrl;
    }

    public void setRewardImageUrl(String rewardImageUrl) {
        this.rewardImageUrl = rewardImageUrl;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public int getAvailableOrderTaskNumber() {
        return availableOrderTaskNumber;
    }

    public void setAvailableOrderTaskNumber(int availableOrderTaskNumber) {
        this.availableOrderTaskNumber = availableOrderTaskNumber;
    }
}
