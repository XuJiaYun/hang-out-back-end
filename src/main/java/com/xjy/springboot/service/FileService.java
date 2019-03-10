package com.xjy.springboot.service;

import com.xjy.springboot.vo.ResponseVO;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    public ResponseVO uploadFile(MultipartFile file);

}
