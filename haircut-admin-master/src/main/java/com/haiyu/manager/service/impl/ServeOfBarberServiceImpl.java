package com.haiyu.manager.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.haiyu.manager.common.R;
import com.haiyu.manager.common.RestResult;
import com.haiyu.manager.common.utils.MyPage;
import com.haiyu.manager.common.utils.RedisUtil;
import com.haiyu.manager.dao.BaseAdminUserMapper;
import com.haiyu.manager.dao.ServeMapper;
import com.haiyu.manager.dao.ServeOfBarberMapper;
import com.haiyu.manager.pojo.BaseAdminUser;
import com.haiyu.manager.pojo.Serve;
import com.haiyu.manager.pojo.ServeOfBarber;
import com.haiyu.manager.response.ServeOfBarberResult;
import com.haiyu.manager.service.ServeOfBarberService;
import com.haiyu.manager.service.ServeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ServeOfBarberServiceImpl implements ServeOfBarberService {
    @Autowired
    private ServeOfBarberMapper mapper;

    @Autowired
    private ServeService serveService;
    @Autowired
    private RedisUtil redisUtil;


    @Override
    public MyPage<ServeOfBarberResult> selectBarberWithServeList(int sid, int id,int pageNum, int pageSize) {
//        ServeOfBarberResult serveOfBarberResult = mapper.selectBarberWithServe(serveOfBarber);
        PageHelper.startPage(pageNum,pageSize);
        List<ServeOfBarberResult> serveOfBarberList  = mapper.selectBarberWithServeList(sid,id);
        if (!serveOfBarberList.isEmpty()){
            serveOfBarberList.forEach(s->{
                String[] split ;
                if (StringUtils.isNotBlank(s.getServeIds())) {
                    split = s.getServeIds().split(",");
                    List<String> serveNames = new ArrayList<>();
                    for (String s1 : split) {
                        //selectOne返回了list 因为自动生成时没有识别主键导致的
                        RestResult restResult = serveService.selectOne(Integer.parseInt(s1));
                        ArrayList arrayList = (ArrayList) restResult.getData();
                        if (!arrayList.isEmpty()){
                            Serve serve = (Serve) arrayList.get(0);
                            serveNames.add(serve.getName());
                        }
                    }
                    s.setServeNames(serveNames.toString());
                }
                boolean b = redisUtil.hasKey(String.format(RedisUtil.ONLINE_KEY_FORMATE,s.getBarberId()));
                if (b)
                    s.setIsOnline(1);
                else
                    s.setIsOnline(0);
            });
        }
        MyPage<ServeOfBarberResult> pageInfo = new MyPage<>(serveOfBarberList);
        pageInfo.setCode(200);
        return pageInfo;
    }
}
