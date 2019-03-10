package com.xjy.springboot.controller;

import com.xjy.springboot.service.ActivityService;
import com.xjy.springboot.vo.ActivityVO;
import com.xjy.springboot.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @RequestMapping(value = "/activity/insert", method = RequestMethod.POST)
    public ResponseVO insertActivity(@RequestBody  ActivityVO activityVO){
        return activityService.insertActivity(activityVO);
    }

    @RequestMapping(value = "/activity/update", method = RequestMethod.POST)
    public ResponseVO updateActivity(@RequestBody ActivityVO activityVO){
        return activityService.updateActivity(activityVO);
    }

    @RequestMapping(value = "/activity/delete", method = RequestMethod.GET)
    public ResponseVO deleteActivity(String travelId){
        return activityService.deleteActivity(travelId);
    }

    @RequestMapping(value = "/activity/selectAllActivity", method = RequestMethod.GET)
    public ResponseVO selectAllActivity(){
        return activityService.selectAllActivity();
    }

    @RequestMapping(value = "/activity/selectActivityByTitle", method = RequestMethod.GET)
    public ResponseVO selectActivityByTitle(String title){
        return activityService.selectActivityByTitle(title);
    }

    @RequestMapping(value = "/activity/selectActivityByTravelId", method = RequestMethod.GET)
    public ResponseVO selectActivityByTravelId(String travelId){
        return activityService.selectActivityByTravelId(travelId);
    }

    @RequestMapping(value = "/activity/selectCreatedOverdueActivity", method = RequestMethod.GET)
    public ResponseVO selectOverdueActivityByOpenId(String openId){
        return activityService.selectCreatedOverdueActivityByOpenId(openId);
    }

    @RequestMapping(value = "/activity/selectCreatedActivity", method = RequestMethod.GET)
    public ResponseVO selectCreatedActivityByOpenId(String openId){
        return activityService.selectCreatedActivityByOpenId(openId);
    }

    @RequestMapping(value = "/activity/selectJoinedActivity",method = RequestMethod.GET)
    public ResponseVO selectJoinedActivityByOpenId(String openId){
        return activityService.selectJoinedActivityByOpenId(openId);
    }
}
