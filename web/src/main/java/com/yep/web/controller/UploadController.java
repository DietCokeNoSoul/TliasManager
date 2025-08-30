package com.yep.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.yep.web.pojo.Result;
import com.yep.web.utils.AliyunOSSOperator;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * 文件上传
 */
@Slf4j
@RestController
@RequestMapping("/upload")
public class UploadController {

    @Autowired
    private AliyunOSSOperator aliyunOSSOperator;

    // /**
    //  * 上传文件
    //  * 本地磁盘
    //  */
    // @PostMapping
    // public Result upload(String name, String age, MultipartFile file) throws IOException {
    //     log.info("姓名: {}, 年龄: {}, 文件名: {}", name, age, file);
    //     // 获取文件名
    //     String fileName = file.getOriginalFilename();
    //     // 获取后缀名
    //     String extension = fileName.substring(fileName.lastIndexOf("."));
    //     // 给予新的文件名,保证文件名不重复
    //     String newFileName = UUID.randomUUID().toString() + extension;
    //     file.transferTo(new File("C:\\Users\\71949\\Desktop\\java code\\upload\\" + newFileName));
    //     return Result.success();
    // }
    @PostMapping
    public Result upload(MultipartFile file) throws Exception{
        log.info("文件名: {}", file);
        // 获取文件名
        String fileName = file.getOriginalFilename();
        String url = aliyunOSSOperator.upload(file.getBytes(), fileName);
        log.info("文件上传OSS成功,url:{}", url);
        return Result.success(url);
    }
}
