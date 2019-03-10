package com.xjy.springboot.mapper;

import com.xjy.springboot.vo.DiaryVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DiaryMapper {

    int insertDiary(DiaryVO diaryVO);

    int deleteDiary(String diaryId);

    DiaryVO selectDiaryByDiaryId(String diaryId);

    List<DiaryVO> selectDiaryByOpenId(String openId);

    int viewDiary(String diaryId);

    int likeDiary(String diaryId);
}
