package com.xjy.springboot.service;

import com.xjy.springboot.mapper.DiaryMapper;
import com.xjy.springboot.vo.DiaryVO;
import com.xjy.springboot.vo.ResponseVO;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class DiaryServiceImpl implements DiaryService{
    @Autowired
    private DiaryMapper diaryMapper;

    @Value("${web.upload.path}")
    private String uploadPath;

    @Override
    public ResponseVO insertDiary(DiaryVO diaryVO) {
        try{
            String diaryId = UUID.randomUUID().toString().replace("-", "").toLowerCase();
            diaryVO.setDiaryId(diaryId);
            diaryVO.setTime(new Date());
            diaryMapper.insertDiary(diaryVO);
            return ResponseVO.buildSuccess();
        }catch (Exception e){
            //如果已经上传了图片，删除该图片
            FileUtils.deleteQuietly(new File(uploadPath+diaryVO.getPictureName()));
            return ResponseVO.buildFailure(e.toString());
        }
    }

    @Override
    public ResponseVO deleteDiary(String diaryId) {
        try{
            DiaryVO diaryVO = diaryMapper.selectDiaryByDiaryId(diaryId);
            diaryMapper.deleteDiary(diaryId);
            //删除该游记内图片
            FileUtils.deleteQuietly(new File(uploadPath+diaryVO.getPictureName()));
            return ResponseVO.buildSuccess();
        }catch (Exception e){
            return ResponseVO.buildFailure(e.toString());
        }
    }

    @Override
    public ResponseVO selectDiaryByDiaryId(String diaryId) {
        try{
            DiaryVO diaryVO = diaryMapper.selectDiaryByDiaryId(diaryId);
            return ResponseVO.buildSuccess(diaryVO);
        }catch (Exception e){
            return ResponseVO.buildFailure(e.toString());
        }
    }

    @Override
    public ResponseVO selectDiaryByOpenId(String openId) {
        try{
            List<DiaryVO> list = diaryMapper.selectDiaryByOpenId(openId);
            return ResponseVO.buildSuccess(list);
        }catch (Exception e){
            return ResponseVO.buildFailure(e.toString());
        }
    }

    @Override
    public ResponseVO viewDiary(String diaryId) {
        try{
            diaryMapper.viewDiary(diaryId);
            return ResponseVO.buildSuccess();
        }catch (Exception e){
            return ResponseVO.buildFailure(e.toString());
        }
    }

    @Override
    public ResponseVO likeDiary(String diaryId) {
        try{
            diaryMapper.likeDiary(diaryId);
            return ResponseVO.buildSuccess();
        }catch (Exception e){
            return ResponseVO.buildFailure(e.toString());
        }
    }
}
