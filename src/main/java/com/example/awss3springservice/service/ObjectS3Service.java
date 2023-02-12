package com.example.awss3springservice.service;

import com.amazonaws.services.s3.model.ListObjectsV2Result;
import com.amazonaws.services.s3.model.S3ObjectSummary;

import java.util.List;

public interface ObjectS3Service {

    boolean uploadObject(String bucketName, String filePath);

    List<S3ObjectSummary> listObjectsS3(String bucketName);

}
