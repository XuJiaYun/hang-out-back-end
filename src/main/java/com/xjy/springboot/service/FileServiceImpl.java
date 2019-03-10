package com.xjy.springboot.service;

import com.xjy.springboot.vo.ResponseVO;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {

    @Value("${web.upload.path}")
    private String uploadPath;

    @Override
    public ResponseVO uploadFile(MultipartFile file) {
        String realFileName = "";
        String fileName = file.getOriginalFilename();
        if(file.isEmpty()){
            realFileName = "";
            return ResponseVO.buildSuccess(realFileName);
        }else{
            String realPath = uploadPath;
            realFileName = UUID.randomUUID().toString().replace("-", "").toLowerCase()+
                    fileName.substring(fileName.lastIndexOf("."));
            String realFileAddress = uploadPath + realFileName;
            try{
                FileUtils.copyInputStreamToFile(file.getInputStream(),new File(realFileAddress));
                return ResponseVO.buildSuccess(realFileName);
            }catch (IOException e){
                return ResponseVO.buildFailure(e.toString());
            }
        }
    }

}
