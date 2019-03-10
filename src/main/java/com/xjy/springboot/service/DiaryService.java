package com.xjy.springboot.service;

import com.xjy.springboot.vo.DiaryVO;
import com.xjy.springboot.vo.ResponseVO;

public interface DiaryService {
    public ResponseVO insertDiary(DiaryVO diaryVO);

    public ResponseVO deleteDiary(String diaryId);

    public ResponseVO selectDiaryByDiaryId(String diaryId);

    public ResponseVO selectDiaryByOpenId(String openId);

    public ResponseVO viewDiary(String diaryId);

    public ResponseVO likeDiary(String diaryId);
}