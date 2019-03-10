package com.xjy.springboot.service;

import com.xjy.springboot.vo.ActivityVO;
import com.xjy.springboot.vo.ResponseVO;

import java.util.List;

public interface ActivityService {
    public ResponseVO insertActivity(ActivityVO activityVO);

    public ResponseVO updateActivity(ActivityVO activityVO);

    public ResponseVO deleteActivity(String travelId);

    public ResponseVO selectAllActivity();

    public ResponseVO selectActivityByTitle(String title);

    public ResponseVO selectActivityByTravelId(String travelId);

    public ResponseVO selectCreatedOverdueActivityByOpenId(String openId);

    public ResponseVO selectCreatedActivityByOpenId(String openId);

    public ResponseVO selectJoinedActivityByOpenId(String openId);
}
