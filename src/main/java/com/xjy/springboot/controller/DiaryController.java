package com.xjy.springboot.controller;

import com.xjy.springboot.service.DiaryService;
import com.xjy.springboot.vo.DiaryVO;
import com.xjy.springboot.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DiaryController {
    @Autowired
    private DiaryService diaryService;

    @RequestMapping(value = "/diary/insert", method = RequestMethod.POST)
    public ResponseVO insertDiary(@RequestBody DiaryVO diaryVO){
        return diaryService.insertDiary(diaryVO);
    }

    @RequestMapping(value = "/diary/delete/{diaryId}", method = RequestMethod.GET)
    public ResponseVO deleteDiary(@PathVariable String diaryId){
        return diaryService.deleteDiary(diaryId);
    }

    @RequestMapping(value = "/diary/{diaryId}", method = RequestMethod.GET)
    public ResponseVO selectDiaryByDiaryId(@PathVariable String diaryId){
        return diaryService.selectDiaryByDiaryId(diaryId);
    }

    @RequestMapping(value = "/diary/selectDiaryByOpenId/{openId}", method = RequestMethod.GET)
    public ResponseVO selectDiaryByOpenId(@PathVariable String openId){
        return diaryService.selectDiaryByOpenId(openId);
    }

    @RequestMapping(value = "/diary/view/{diaryId}", method = RequestMethod.GET)
    public ResponseVO viewDiary(@PathVariable String diaryId){
        return diaryService.viewDiary(diaryId);
    }

    @RequestMapping(value = "/diary/like/{diaryId}", method = RequestMethod.GET)
    public ResponseVO likeDiary(@PathVariable String diaryId){
        return diaryService.likeDiary(diaryId);
    }
}
