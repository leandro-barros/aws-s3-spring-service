package com.example.awss3springservice.service.impl;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.example.awss3springservice.config.AmazonConfig;
import com.example.awss3springservice.service.ObjectS3Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.nio.file.Paths;

@Slf4j
public class ObjectS3ServiceImpl implements ObjectS3Service {

    @Autowired
    private AmazonConfig amazonConfig;

    @Override
    public boolean uploadObject(String bucketName, String filePath) {
        filePath = "/home/imagens/" + filePath;
        String keyName = Paths.get(filePath).getFileName().toString();

        AmazonS3 s3 = amazonConfig.amazonS3Config();

        try {
            PutObjectResult uploding = s3.putObject(bucketName, keyName, new File(filePath));
        } catch (AmazonS3Exception e) {
            log.info("Error in to make upload object.");
        }
        return true;
    }

}
