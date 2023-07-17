package com.pet.pro.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import com.pet.pro.service.OssService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;


@Service
public class OssUploadServiceImpl implements OssService {




    @Override
    public String uploadFile(MultipartFile multipartFile){

        String endpoint = "oss-cn-beijing.aliyuncs.com";
        // 阿里云账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM用户进行API访问或日常运维，请登录RAM控制台创建RAM用户。
        String accessKeyId = "6";
        String accessKeySecret = "6";
        // 填写Bucket名称，例如examplebucket。
        String bucketName = "cg666";

        try {
            // 创建OSSClient实例。
            OSS ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);

            //获取文件上传流
            InputStream inputStream = multipartFile.getInputStream();

            //构建日期目录
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            String datePath = dateFormat.format(new Date());

            //获取文件名
            String originalFilename = multipartFile.getOriginalFilename();

            String uuid = UUID.randomUUID().toString().replace("-", "");
            originalFilename = uuid + originalFilename;

            originalFilename = datePath + "/" + originalFilename;

            String fileUrl = originalFilename;

            //文件上传到阿里云服务器
            ossClient.putObject(bucketName, fileUrl, inputStream);
            ossClient.shutdown();
            String Url = "https://" + bucketName + "." +endpoint + "/" + fileUrl;
            return Url;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
