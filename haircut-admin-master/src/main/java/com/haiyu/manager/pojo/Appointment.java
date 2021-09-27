package com.haiyu.manager.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Appointment {
    private Integer aid;

    private Integer max;

    private Integer customerId;

    private String customerName;

    private String customerPhone;

    private String customerAvatar;

    private Integer sid;

    private String storeName;

    private Integer serverId;

    private String serverName;

    private Integer barberId;

    private String barberAvatar;

    private String barberPhone;

    private String barberName;

    private Integer price;

    private Integer status;

    private String note;

    private Integer segment;

    private Integer number;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date day;

    private Date time;

    private Integer noon;

    private String noonname;

    private Integer rid;


    private String startTime;

    private String endTime;

    private Date startTime1;

    private Date endTime1;

    private Date createdTime;

    private Integer isReview;

    private Integer isNotice;

    public Integer getIsNotice() {
        return isNotice;
    }

    public void setIsNotice(Integer isNotice) {
        this.isNotice = isNotice;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getIsReview() {
        return isReview;
    }

    public void setIsReview(Integer isReview) {
        this.isReview = isReview;
    }

    public Date getStartTime1() {
        return startTime1;
    }

    public void setStartTime1(Date startTime1) {
        this.startTime1 = startTime1;
    }

    public Date getEndTime1() {
        return endTime1;
    }

    public void setEndTime1(Date endTime1) {
        this.endTime1 = endTime1;
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

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName == null ? null : customerName.trim();
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone == null ? null : customerPhone.trim();
    }

    public String getCustomerAvatar() {
        return customerAvatar;
    }

    public void setCustomerAvatar(String customerAvatar) {
        this.customerAvatar = customerAvatar == null ? null : customerAvatar.trim();
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName == null ? null : storeName.trim();
    }

    public Integer getServerId() {
        return serverId;
    }

    public void setServerId(Integer serverId) {
        this.serverId = serverId;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName == null ? null : serverName.trim();
    }

    public Integer getBarberId() {
        return barberId;
    }

    public void setBarberId(Integer barberId) {
        this.barberId = barberId;
    }

    public String getBarberAvatar() {
        return barberAvatar;
    }

    public void setBarberAvatar(String barberAvatar) {
        this.barberAvatar = barberAvatar == null ? null : barberAvatar.trim();
    }

    public String getBarberPhone() {
        return barberPhone;
    }

    public void setBarberPhone(String barberPhone) {
        this.barberPhone = barberPhone == null ? null : barberPhone.trim();
    }

    public String getBarberName() {
        return barberName;
    }

    public void setBarberName(String barberName) {
        this.barberName = barberName == null ? null : barberName.trim();
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public Integer getSegment() {
        return segment;
    }

    public void setSegment(Integer segment) {
        this.segment = segment;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getNoon() {
        return noon;
    }

    public void setNoon(Integer noon) {
        this.noon = noon;
    }

    public String getNoonname() {
        return noonname;
    }

    public void setNoonname(String noonname) {
        this.noonname = noonname == null ? null : noonname.trim();
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
}