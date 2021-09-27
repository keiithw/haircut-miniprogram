package com.haiyu.manager.service;

import com.haiyu.manager.pojo.Review;

import java.util.List;

public interface ReviewService {
    List<Review> getSimpleReview(int bid);

    Integer countBySid(int sid);

    List<Review> getLatest5(int sid);
}
