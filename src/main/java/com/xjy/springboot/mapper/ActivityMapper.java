package com.xjy.springboot.mapper;

import com.xjy.springboot.vo.ActivityVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ActivityMapper {
    int insertActivity(ActivityVO activityVO);

    int updateActivity(ActivityVO activityVO);

    int deleteActivity(String travelId);

    List<ActivityVO> selectAllActivity();

    List<ActivityVO> selectActivityByTitle(@Param("title") String title);

    ActivityVO selectActivityByTravelId(String travelId);

    List<ActivityVO> selectCreatedOverdueActivityByOpenId(String openId);

    List<ActivityVO> selectCreatedActivityByOpenId(String openId);

    List<ActivityVO> selectJoinedActivityByOpenId(String openId);
}
