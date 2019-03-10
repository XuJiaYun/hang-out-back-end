package com.xjy.springboot.service;

import com.xjy.springboot.mapper.NoticeMapper;
import com.xjy.springboot.vo.NoticeInfoVO;
import com.xjy.springboot.vo.NoticeVO;
import com.xjy.springboot.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeMapper noticeMapper;

    @Override
    public ResponseVO deleteNoticeByNoticeId(String noticeId) {
        try{
            noticeMapper.deleteNoticeByNoticeId(noticeId);
            return ResponseVO.buildSuccess();
        }catch (Exception e){
            return ResponseVO.buildFailure(e.toString());
        }
    }

    @Override
    public ResponseVO insertNotice(NoticeVO noticeVO) {
        String noticeId = UUID.randomUUID().toString().replace("-","").toLowerCase();
        noticeVO.setNoticeId(noticeId);
        noticeVO.setNoticeTime(new Date());
        try{
            noticeMapper.insertNotice(noticeVO);
            return ResponseVO.buildSuccess();
        }catch (Exception e){
            return ResponseVO.buildFailure(e.toString());
        }
    }

    @Override
    public ResponseVO selectNoticeByTravelId(String travelId) {
        try{
           List<NoticeInfoVO> list = noticeMapper.selectNoticeByTravelId(travelId);
           return ResponseVO.buildSuccess(list);
        }catch (Exception e){
            return ResponseVO.buildFailure(e.toString());
        }
    }
}
