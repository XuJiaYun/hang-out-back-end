package com.xjy.springboot.mapper;

import com.xjy.springboot.vo.AttendListVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AttendListMapper {
    int insertAttendList(AttendListVO attendListVO);

    int deleteAttendList(AttendListVO attendListVO);

    int deleteAttendListByTravelId(String travelId);

    int isAttendListExist(AttendListVO attendListVO);
}
