package com.pandaria.farmland.biz.entity;

import com.pandaria.farmland.toolkits.utils.JsonUtil;

public class Activity {

    private int id;
    private String description;
    private Order order;
    private String rewardImageUrl;
    private int availableOrderTaskNumber;
    private String startTime;
    private String endTime;
    private String addDate;

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

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getAvailableOrderTaskNumber() {
        return availableOrderTaskNumber;
    }

    public void setAvailableOrderTaskNumber(int availableOrderTaskNumber) {
        this.availableOrderTaskNumber = availableOrderTaskNumber;
    }

    public String getAddDate() {
        return addDate;
    }

    public void setAddDate(String addDate) {
        this.addDate = addDate;
    }

    @Override
    public String toString() {
        return JsonUtil.objectToString(this);
    }
}
