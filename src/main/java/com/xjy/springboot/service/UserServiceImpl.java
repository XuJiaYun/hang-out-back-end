package com.xjy.springboot.service;

import com.xjy.springboot.mapper.UserMapper;
import com.xjy.springboot.vo.ResponseVO;
import com.xjy.springboot.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.Response;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    public ResponseVO getUserByOpenId(String openId){
        try {
            UserVO userVO = userMapper.getUserByOpenId(openId);
            return ResponseVO.buildSuccess(userVO);
        }catch (Exception e){
            return ResponseVO.buildFailure(e.toString());
        }
    }


    public ResponseVO insertUser(UserVO userVO) {
        try {
            userMapper.insertUser(userVO);
            return ResponseVO.buildSuccess(userVO);
        }catch (Exception e){
            return ResponseVO.buildFailure(e.toString());
        }
    }


    public ResponseVO updateUser(UserVO userVO) {
        try{
            userMapper.updateUserByOpenId(userVO);
            return ResponseVO.buildSuccess();
        }catch (Exception e){
            return ResponseVO.buildFailure(e.toString());
        }
    }

    @Override
    public ResponseVO selectUserByTravelId(String travelId) {
        try{
            List<UserVO> list = userMapper.selectUserByTravelId(travelId);
            return ResponseVO.buildSuccess(list);
        }catch (Exception e){
            return ResponseVO.buildFailure(e.toString());
        }
    }
}
