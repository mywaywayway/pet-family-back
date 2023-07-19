package com.pet.pro.controller;



import com.pet.pro.Result;
import com.pet.pro.service.OssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController("OssController")
@RequestMapping("/oss")
@CrossOrigin
public class OssController {
    @Autowired
    private OssService ossService;
    @PostMapping("/upload")
    public Result uploadFile(MultipartFile file){
        String s = ossService.uploadFile(file);
        return Result.success(s,"成功");
    }
}
