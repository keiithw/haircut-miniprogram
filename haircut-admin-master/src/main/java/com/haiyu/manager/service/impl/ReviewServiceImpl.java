package com.haiyu.manager.service.impl;


import com.haiyu.manager.dao.ReviewMapper;
import com.haiyu.manager.pojo.Review;
import com.haiyu.manager.pojo.example.AppointmentExample;
import com.haiyu.manager.pojo.example.ReviewExample;
import com.haiyu.manager.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    private ReviewMapper reviewMapper;

    @Override
    public List<Review> getSimpleReview(@RequestParam int bid) {
        List<Review> simpleReview = reviewMapper.getSimpleReview(bid);
        return simpleReview;
    }

    @Override
    public Integer countBySid(int sid) {
        ReviewExample example = new ReviewExample();
        example.createCriteria().andSidEqualTo(sid);
        int i = reviewMapper.countByExample(example);
        return i;
    }

    @Override
    public List<Review> getLatest5(int sid) {
        return reviewMapper.getLatest5(sid);
    }
}
