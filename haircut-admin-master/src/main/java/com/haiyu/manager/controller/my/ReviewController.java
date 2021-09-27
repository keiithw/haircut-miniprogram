package com.haiyu.manager.controller.my;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.haiyu.manager.common.R;
import com.haiyu.manager.common.RestResult;
import com.haiyu.manager.dao.ReviewMapper;
import com.haiyu.manager.pojo.Review;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReviewController {

    @Autowired
    private ReviewMapper reviewMapper;

    @PostMapping("review/pageStoreReview")
    public RestResult pageStoreReview(@RequestBody Review review) {
        if (StringUtils.isNotBlank(review.getServeName()) && review.getServeName().equals("-555"))
            review.setServeName(null);
        if (review.getBid() != null && review.getBid() == -555)
            review.setBid(null);
        PageHelper.startPage(review.getPageNum(), review.getPageSize());
        List<Review> reviews = reviewMapper.pageStoreReview(review);
        Page<Review> page = (Page<Review>) reviews;
        return R.getSuccessResult(page);
    }
}
