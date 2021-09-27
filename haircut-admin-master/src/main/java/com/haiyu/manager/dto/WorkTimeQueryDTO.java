package com.haiyu.manager.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class WorkTimeQueryDTO {
    public int sid;

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    public String start;

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    public String end;
}
