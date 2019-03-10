package com.xjy.springboot.controller;

import com.xjy.springboot.service.NoticeService;
import com.xjy.springboot.vo.NoticeVO;
import com.xjy.springboot.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @RequestMapping(value = "/notice/insert", method = RequestMethod.POST)
    public ResponseVO insertNotice(@RequestBody NoticeVO noticeVO){
        return noticeService.insertNotice(noticeVO);
    }

    @RequestMapping(value = "/notice/{travelId}", method = RequestMethod.GET)
    public ResponseVO selectNoticeByTravelId(@PathVariable String travelId){
        return noticeService.selectNoticeByTravelId(travelId);
    }

    @RequestMapping(value = "/notice/delete/{noticeId}", method = RequestMethod.GET)
    public ResponseVO deleteNoticeByNoticeId(@PathVariable String noticeId){
        return noticeService.deleteNoticeByNoticeId(noticeId);
    }
}
