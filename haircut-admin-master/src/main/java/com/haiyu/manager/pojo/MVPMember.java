package com.haiyu.manager.pojo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class MVPMember {
    private String name;
    private int finDeal;
    private int totalBenefit;
    private int goodComment;
    private List<String> title = new ArrayList<>();

}
