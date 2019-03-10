package com.xjy.springboot.controller;

import com.xjy.springboot.service.AttendListService;
import com.xjy.springboot.vo.AttendListVO;
import com.xjy.springboot.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AttendListController {
    @Autowired
    private AttendListService attendListService;

    @RequestMapping(value = "/attendList/insert", method = RequestMethod.POST)
    public ResponseVO insertAttendList(@RequestBody AttendListVO attendListVO){
        return attendListService.insertAttendList(attendListVO);
    }

    @RequestMapping(value = "/attendList/delete", method = RequestMethod.POST)
    public ResponseVO deleteAttendList(@RequestBody AttendListVO attendListVO){
        return attendListService.deleteAttendList(attendListVO);
    }

    @RequestMapping(value = "/attendList/isExist", method = RequestMethod.POST)
    public ResponseVO isAttendListExist(@RequestBody AttendListVO attendListVO){
        return attendListService.isAttendListExist(attendListVO);
    }
}
