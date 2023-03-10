package com.example.awss3springservice.service.impl;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.services.s3.model.ListObjectsV2Result;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.example.awss3springservice.config.AmazonConfig;
import com.example.awss3springservice.service.ObjectS3Service;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.file.Paths;
import java.util.List;

@AllArgsConstructor
@Service
@Slf4j
public class ObjectS3ServiceImpl implements ObjectS3Service {

    private final AmazonConfig amazonConfig;

    @Override
    public boolean uploadObject(String bucketName, String filePath) {
        String keyName = Paths.get(filePath).getFileName().toString();

        if (!fileVerificationType(filePath)) {
            log.info("File is not image");
            return false;
        }

        AmazonS3 s3 = amazonConfig.amazonS3Config();

        try {
            PutObjectResult uploding = s3.putObject(bucketName, keyName, new File(filePath));
        } catch (AmazonS3Exception e) {
            log.info("Error in to make upload object.");
        }
        return true;
    }

    @Override
    public List<S3ObjectSummary> listObjectsS3(String bucketName) {
        AmazonS3 s3 = amazonConfig.amazonS3Config();
        ListObjectsV2Result result = s3.listObjectsV2(bucketName);
        List<S3ObjectSummary> s3ObjectSummaries = result.getObjectSummaries();
//        for (S3ObjectSummary s3ObjectSummary : s3ObjectSummaries) {
//            log.info("* Key Object: {}" + s3ObjectSummary.getKey());
//        }
        return s3ObjectSummaries;
    }

    public boolean fileVerificationType(String filePath) {
        String fileName = new File(filePath).getName();

        if(fileName.contains(".png") || fileName.contains(".jpeg") || fileName.contains(".jpg")) {
            log.info("This file is an image, o update will to continue.");
            return true;
        }

        int positionAfterDot = fileName.lastIndexOf(".");
        log.info("The file is not an image.", fileName.substring(positionAfterDot + 1));
        return false;
    }

}
