package com.haiyu.manager.dao;

import com.haiyu.manager.pojo.Review;
import com.haiyu.manager.pojo.example.ReviewExample;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewMapper {
    int countByExample(ReviewExample example);

    int deleteByExample(ReviewExample example);

    int deleteByPrimaryKey(Integer rid);

    int insert(Review record);

    int insertSelective(Review record);

    List<Review> selectByExample(ReviewExample example);

    Review selectByPrimaryKey(Integer rid);

    int updateByExampleSelective(@Param("record") Review record, @Param("example") ReviewExample example);

    int updateByExample(@Param("record") Review record, @Param("example") ReviewExample example);

    int updateByPrimaryKeySelective(Review record);

    int updateByPrimaryKey(Review record);

    List<Review> getSimpleReview(int sid);

    List<Review> getStoreReview(int sid);

    List<Review> getSimpleBarberReview(int bid);

    List<Review> getBarberReview(int sid);

    List<Review> pageStoreReview(Review review);

    Integer getQueuedNumber(int sid);

    Double getStoreMark(int sid);

    Double getBarberMark(int bid);

    List<Review> getLatest5(int sid);
}