package com.haiyu.manager.controller.my;

import com.haiyu.manager.common.RestResult;
import com.haiyu.manager.pojo.WorkTime;
import com.haiyu.manager.service.WorkTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("calendar")
public class CalendarController {

    @Autowired
    private WorkTimeService workTimeService;

    @GetMapping("getByParams")
    public List<WorkTime> getByParams(@RequestParam String start,@RequestParam String end,@RequestParam int sid,@RequestParam int barberId) {
        List<WorkTime> list = workTimeService.getByParams(start,end,sid,barberId);
        return list;
    }

    @PostMapping("create")
    public RestResult create(@RequestBody WorkTime workTime){
        return workTimeService.create(workTime);
    }

    @PostMapping("update")
    public RestResult update(WorkTime workTime){
        return workTimeService.update(workTime);
    }

    @GetMapping("deleteById")
    public RestResult del(int id){
        return workTimeService.del(id);
    }

}
