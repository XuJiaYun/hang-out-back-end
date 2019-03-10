package com.xjy.springboot.controller;

import com.xjy.springboot.service.UserService;
import com.xjy.springboot.service.UserServiceImpl;
import com.xjy.springboot.vo.ResponseVO;
import com.xjy.springboot.vo.UserVO;
import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/{openId}", method = RequestMethod.GET)
    public ResponseVO getUser(@PathVariable String openId){
        return userService.getUserByOpenId(openId);
    }
    @RequestMapping(value = "/user/insert", method = RequestMethod.POST)
    public ResponseVO insertUser(@RequestBody UserVO userVO){
        return userService.insertUser(userVO);
    }
    @RequestMapping(value = "/user/update", method = RequestMethod.POST)
    public ResponseVO updateUser(@RequestBody UserVO userVO){
        return userService.updateUser(userVO);
    }
    @RequestMapping(value = "/user/selectUserByTravelId/{travelId}", method = RequestMethod.GET)
    public ResponseVO selectUserByTravelId(@PathVariable String travelId){
        return userService.selectUserByTravelId(travelId);
    }
}
