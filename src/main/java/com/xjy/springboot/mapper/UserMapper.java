package com.xjy.springboot.mapper;

import com.xjy.springboot.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    UserVO getUserByOpenId (String openId);

    int insertUser(UserVO userVO);

    int updateUserByOpenId(UserVO userVO);

    List<UserVO> selectUserByTravelId(String travelId);
}
