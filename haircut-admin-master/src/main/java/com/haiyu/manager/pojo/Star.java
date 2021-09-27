package com.haiyu.manager.pojo;

import java.util.Date;

public class Star {
    private Integer id;

    private Integer customerId;

    private Integer targetId;

    private Integer isShop;

    private Integer star;

    private Date createdTime;

    public Star(Integer customerId, Integer targetId, Integer isShop, Integer star, Date createdTime) {
        this.customerId = customerId;
        this.targetId = targetId;
        this.isShop = isShop;
        this.star = star;
        this.createdTime = createdTime;
    }

    public Star(Integer customerId, Integer targetId, Integer star) {
        this.customerId = customerId;
        this.targetId = targetId;
        this.star = star;
    }

    public Star() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getTargetId() {
        return targetId;
    }

    public void setTargetId(Integer targetId) {
        this.targetId = targetId;
    }

    public Integer getIsShop() {
        return isShop;
    }

    public void setIsShop(Integer isShop) {
        this.isShop = isShop;
    }

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
}