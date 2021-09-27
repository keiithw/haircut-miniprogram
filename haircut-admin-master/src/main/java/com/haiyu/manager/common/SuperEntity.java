package com.haiyu.manager.common;

import lombok.Data;

import java.util.Date;

@Data
public class SuperEntity {
    int pageSize = 1;
    int pageNum = 10;
    Date startTime;
    Date endTime;
}
