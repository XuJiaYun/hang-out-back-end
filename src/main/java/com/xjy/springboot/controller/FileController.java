package com.xjy.springboot.controller;

import com.xjy.springboot.service.FileService;
import com.xjy.springboot.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
public class FileController {

    @Autowired
    private FileService fileService;

    @RequestMapping(value = "/file/upload", method = RequestMethod.POST)
    public ResponseVO uploadFile(@RequestParam MultipartFile file){
        return fileService.uploadFile(file);
    }

}
