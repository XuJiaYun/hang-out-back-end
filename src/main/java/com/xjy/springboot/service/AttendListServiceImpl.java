package com.xjy.springboot.service;


import com.xjy.springboot.mapper.AttendListMapper;
import com.xjy.springboot.vo.AttendListVO;
import com.xjy.springboot.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttendListServiceImpl implements AttendListService {
    @Autowired
    private AttendListMapper attendListMapper;

    @Override
    public ResponseVO insertAttendList(AttendListVO attendListVO) {
        try {
            attendListMapper.insertAttendList(attendListVO);
            return ResponseVO.buildSuccess();
        }catch (Exception e){
            return ResponseVO.buildFailure(e.toString());
        }
    }

    @Override
    public ResponseVO deleteAttendList(AttendListVO attendListVO) {
        try{
            attendListMapper.deleteAttendList(attendListVO);
            return ResponseVO.buildSuccess();
        }catch (Exception e){
            return ResponseVO.buildFailure(e.toString());
        }
    }

    @Override
    public ResponseVO isAttendListExist(AttendListVO attendListVO) {
        try{
            int success = attendListMapper.isAttendListExist(attendListVO);
            return ResponseVO.buildSuccess(success);
        }catch (Exception e){
            return  ResponseVO.buildFailure(e.toString());
        }
    }
}
