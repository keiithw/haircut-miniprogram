package com.haiyu.manager.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

public class WorkTime {
    private Integer id;

    private Integer sid;

    private String title;

    private Integer barberId;

    private String barberName;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String start;

    private String end;

    private Integer noon;

    private String noonName;

    private Integer intervalMax;

    private Boolean allDay;

    public Boolean getAllDay() {
        return allDay;
    }

    public void setAllDay(Boolean allDay) {
        this.allDay = allDay;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getBarberId() {
        return barberId;
    }

    public void setBarberId(Integer barberId) {
        this.barberId = barberId;
    }

    public String getBarberName() {
        return barberName;
    }

    public void setBarberName(String barberName) {
        this.barberName = barberName == null ? null : barberName.trim();
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start == null ? null : start.trim();
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end == null ? null : end.trim();
    }

    public Integer getNoon() {
        return noon;
    }

    public void setNoon(Integer noon) {
        this.noon = noon;
    }

    public String getNoonName() {
        return noonName;
    }

    public void setNoonName(String noonName) {
        this.noonName = noonName == null ? null : noonName.trim();
    }

    public Integer getIntervalMax() {
        return intervalMax;
    }

    public void setIntervalMax(Integer intervalMax) {
        this.intervalMax = intervalMax;
    }

}