package com.haiyu.manager.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.haiyu.manager.common.utils.DistancecalculatorUtil;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.Optional;

public class BaseAdminUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer sid;

    private String sysUserName;

    private String sysUserPwd;

    private Integer roleId;

    private String userPhone;

    private String regTime;

    private Integer userStatus;

    private String introduce;

    private String profilePhoto;

    private Integer sex;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    private Integer isShop;

    private String latitude;

    private String longitude;

    private Integer working = 0;

    private String address;

    private String distance;

    private int rate = 100;

    private int queue;

    private String mark;

    private String price;

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = new DecimalFormat("#.0").format(price);
    }

    public int getQueue() {
        return queue;
    }

    public void setQueue(int queue) {
        this.queue = queue;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = new DecimalFormat("#.0").format(mark);
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public double getDistance(double targetLatitude, double targetLongitude){
        DistancecalculatorUtil distancecalculatorUtil = new DistancecalculatorUtil();
        return distancecalculatorUtil.getSphereDistanceMeter(
                Double.parseDouble(Optional.ofNullable(latitude).orElse("0")),
                Double.parseDouble(Optional.ofNullable(longitude).orElse("0"))
                ,targetLatitude,targetLongitude);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSysUserName() {
        return sysUserName;
    }

    public void setSysUserName(String sysUserName) {
        this.sysUserName = sysUserName == null ? null : sysUserName.trim();
    }

    public String getSysUserPwd() {
        return sysUserPwd;
    }

    public void setSysUserPwd(String sysUserPwd) {
        this.sysUserPwd = sysUserPwd == null ? null : sysUserPwd.trim();
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    public String getRegTime() {
        return regTime;
    }

    public void setRegTime(String regTime) {
        this.regTime = regTime == null ? null : regTime.trim();
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce == null ? null : introduce.trim();
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto == null ? null : profilePhoto.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getIsShop() {
        return isShop;
    }

    public void setIsShop(Integer isShop) {
        this.isShop = isShop;
    }

    public String  getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public Integer getWorking() {
        return working;
    }

    public void setWorking(Integer working) {
        this.working = working;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }
}