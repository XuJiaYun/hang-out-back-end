package com.xjy.springboot.service;

import com.xjy.springboot.vo.NoticeVO;
import com.xjy.springboot.vo.ResponseVO;



public interface NoticeService {

    public ResponseVO insertNotice(NoticeVO noticeVO);

    public ResponseVO selectNoticeByTravelId(String travelId);

    public ResponseVO deleteNoticeByNoticeId(String noticeId);
}
