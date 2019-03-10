package com.xjy.springboot.mapper;

import com.xjy.springboot.vo.NoticeInfoVO;
import com.xjy.springboot.vo.NoticeVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface NoticeMapper {

    int insertNotice(NoticeVO noticeVO);

    List<NoticeInfoVO> selectNoticeByTravelId(String travelId);

    int deleteNoticeByNoticeId(String noticeId);
}
