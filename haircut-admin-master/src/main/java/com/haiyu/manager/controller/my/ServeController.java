package com.haiyu.manager.controller.my;

import com.github.pagehelper.PageHelper;
import com.haiyu.manager.common.RestResult;
import com.haiyu.manager.common.utils.RedisUtil;
import com.haiyu.manager.common.utils.SnowflakeIdUtils;
import com.haiyu.manager.common.R;
import com.haiyu.manager.common.utils.MyPage;
import com.haiyu.manager.dao.ServeMapper;
import com.haiyu.manager.dao.ServeOfBarberMapper;
import com.haiyu.manager.pojo.Serve;
import com.haiyu.manager.pojo.ServeOfBarber;
import com.haiyu.manager.pojo.example.ServeOfBarberExample;
import com.haiyu.manager.service.ServeOfBarberService;
import com.haiyu.manager.service.ServeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

import javax.xml.ws.Service;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/serve")
public class ServeController {

    @Autowired
    private ServeMapper serveMapper;

    @Autowired
    private ServeService serveService;

    @Autowired
    private ServeOfBarberService serveOfBarberService;

    @Autowired
    private ServeOfBarberMapper serveOfBarberMapper;

    @Autowired
    private SnowflakeIdUtils snowflakeIdUtils;

    @Autowired
    private RedisUtil redisUtil;

    private String ONLINE_KEY_FORMAT="ONLINE:%s";

   @PostMapping("/insetOrUpdate")
   public RestResult insetOrUpdate(Serve serve){
       int i = 0;
       if (serve.getId()!=null){
           return serveService.editServe(serve);
       }
       long nextId = snowflakeIdUtils.nextId();
       serve.setId((int) nextId);
       i = serveMapper.insertSelective(serve);
       return i ==1 ? R.getSuccessResult():R.getFailResult("查询失败");
   }

   @GetMapping("/list")
    public MyPage listServers(@RequestParam(defaultValue = "1") int pageNum,
                                  @RequestParam(defaultValue = "10") int pageSize,
                                  @RequestParam int sid){
       PageHelper.startPage(pageNum,pageSize);
       List<Serve> serves = serveService.listByStore(sid);
       MyPage myPage = new MyPage(serves);
       myPage.setCode(200);
       return myPage;
   }

    @GetMapping("/listAll")
    public List<Serve> listAll(@RequestParam int sid){
        List<Serve> serves = serveService.listByStore(sid);
        serves.forEach(s->s.setIsOnline(redisUtil.hasKey(String.format(ONLINE_KEY_FORMAT,s.getId()))?"在线":"休息中"));
        return serves;
    }

   @PostMapping("/edit")
    public RestResult editServe(@RequestBody Serve serve){
        return serveService.editServe(serve);
   }

   @GetMapping("/selectOne")
   public RestResult selectOne(@RequestParam int id){
       return serveService.selectOne(id);
   }

   @PostMapping("/delete")
    public RestResult delete(@RequestParam int id){return serveService.delete(id);}

    @PostMapping("/setForTony")
    public RestResult setForTony(ServeOfBarber serveOfBarber){
       if (serveOfBarber.getBarberId() == null){
           if (serveOfBarberMapper.insert(serveOfBarber)==1)
               return R.getSuccessResult();
           return R.getFailResult("新增失败");
       } else {
           ServeOfBarberExample serveOfBarberExample = new ServeOfBarberExample();
           ServeOfBarberExample.Criteria criteria = serveOfBarberExample.createCriteria();
           criteria.andIdEqualTo(serveOfBarber.getId());
           int i = serveOfBarberMapper.updateByExampleSelective(serveOfBarber,serveOfBarberExample);
            if (i == 1) return R.getSuccessResult();
        }
        return R.getFailResult("更新失败");
    }

    @GetMapping("getBarberWithServe")
    public MyPage selectBarberWithServe(@RequestParam int sid,
                                            @RequestParam int id,
                                            @RequestParam int pageNum,
                                            @RequestParam int pageSize){
       return serveOfBarberService.selectBarberWithServeList(sid,id,pageNum,pageSize);
    }

}
