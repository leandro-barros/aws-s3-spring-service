package com.example.awss3springservice.service;

public interface ObjectS3Service {

    boolean uploadObject(String bucketName, String filePath);

}
