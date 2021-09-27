package com.haiyu.manager.response;

import lombok.Data;

import java.util.List;

@Data
public class ServeOfBarberResult {
    private Integer id;

    private Integer barberId;

    private String barberName;

    private String serveIds;

    private String serveNames;

    private int sid;

    private int isOnline;

}
