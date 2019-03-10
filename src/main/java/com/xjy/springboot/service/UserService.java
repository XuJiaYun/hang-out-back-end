package com.xjy.springboot.service;

import com.xjy.springboot.vo.ResponseVO;
import com.xjy.springboot.vo.UserVO;

public interface UserService {
    public ResponseVO getUserByOpenId(String openId);

    public ResponseVO insertUser(UserVO userVO);

    public ResponseVO updateUser(UserVO userVO);

    public ResponseVO selectUserByTravelId(String travelId);
}
