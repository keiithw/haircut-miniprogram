package com.haiyu.manager.pojo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class ServeOfBarber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer barberId;

    private String serveIds;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBarberId() {
        return barberId;
    }

    public void setBarberId(Integer barberId) {
        this.barberId = barberId;
    }

    public String getServeIds() {
        return serveIds;
    }

    public void setServeIds(String serveIds) {
        this.serveIds = serveIds == null ? null : serveIds.trim();
    }
}