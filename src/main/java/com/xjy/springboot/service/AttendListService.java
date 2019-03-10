package com.xjy.springboot.service;

import com.xjy.springboot.vo.AttendListVO;
import com.xjy.springboot.vo.ResponseVO;

public interface AttendListService {
    ResponseVO insertAttendList (AttendListVO attendListVO);

    ResponseVO deleteAttendList (AttendListVO attendListVO);

    ResponseVO isAttendListExist (AttendListVO attendListVO);
}
