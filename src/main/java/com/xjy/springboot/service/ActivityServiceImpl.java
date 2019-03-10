package com.xjy.springboot.service;

import com.xjy.springboot.mapper.ActivityMapper;
import com.xjy.springboot.mapper.AttendListMapper;
import com.xjy.springboot.vo.ActivityVO;
import com.xjy.springboot.vo.AttendListVO;
import com.xjy.springboot.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;
@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityMapper activityMapper;

    @Autowired
    private AttendListMapper attendListMapper;

    @Override
    public ResponseVO insertActivity(ActivityVO activityVO) {
        try {
            String uuid = UUID.randomUUID().toString().replace("-", "");
            activityVO.setTravelId(uuid);
            AttendListVO attendListVO = new AttendListVO();
            attendListVO.setOpenId(activityVO.getOpenId());
            attendListVO.setTravelId(uuid);
            activityMapper.insertActivity(activityVO);
            attendListMapper.insertAttendList(attendListVO);
            return ResponseVO.buildSuccess();
        } catch (Exception e) {
            return ResponseVO.buildFailure(e.toString());
        }
    }

    @Override
    public ResponseVO updateActivity(ActivityVO activityVO) {
        try{
            int success = activityMapper.updateActivity(activityVO);
            return ResponseVO.buildSuccess(success);
        }catch (Exception e){
            return ResponseVO.buildFailure(e.toString());
        }
    }

    @Override
    public ResponseVO deleteActivity(String travelId) {
        try{
            activityMapper.deleteActivity(travelId);
            attendListMapper.deleteAttendListByTravelId(travelId);
            return ResponseVO.buildSuccess();
        }catch (Exception e){
            return ResponseVO.buildFailure(e.toString());
        }
    }

    @Override
    public ResponseVO selectAllActivity() {
        try{
            List list = activityMapper.selectAllActivity();
            return ResponseVO.buildSuccess(list);
        }catch (Exception e){
            return ResponseVO.buildFailure(e.toString());
        }
    }

    @Override
    public ResponseVO selectActivityByTitle(String title) {
        try{
            List list = activityMapper.selectActivityByTitle(title);
            return ResponseVO.buildSuccess(list);
        }catch (Exception e){
            return ResponseVO.buildFailure(e.toString());
        }
    }

    @Override
    public ResponseVO selectActivityByTravelId(String travelId) {
        try{
            ActivityVO activityVO = activityMapper.selectActivityByTravelId(travelId);
            return ResponseVO.buildSuccess(activityVO);
        }catch(Exception e){
            return ResponseVO.buildFailure(e.toString());
        }
    }

    @Override
    public ResponseVO selectCreatedOverdueActivityByOpenId(String openId) {
        try{
            List<ActivityVO> list = activityMapper.selectCreatedOverdueActivityByOpenId(openId);
            return ResponseVO.buildSuccess(list);
        }catch (Exception e){
            return ResponseVO.buildFailure(e.toString());
        }
    }

    @Override
    public ResponseVO selectCreatedActivityByOpenId(String openId) {
        try{
            List<ActivityVO> list = activityMapper.selectCreatedActivityByOpenId(openId);
            return ResponseVO.buildSuccess(list);
        }catch (Exception e){
            return ResponseVO.buildFailure(e.toString());
        }
    }

    @Override
    public ResponseVO selectJoinedActivityByOpenId(String openId) {
        try{
            List<ActivityVO> list = activityMapper.selectJoinedActivityByOpenId(openId);
            return ResponseVO.buildSuccess(list);
        }catch (Exception e){
            return ResponseVO.buildFailure(e.toString());
        }
    }
}
