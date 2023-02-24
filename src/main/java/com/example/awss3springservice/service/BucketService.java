package com.example.awss3springservice.service;

import com.amazonaws.services.s3.model.Bucket;

import java.util.List;

public interface BucketService {

    Bucket findBucket(String bucketName);

    List<Bucket> listOfBuckets();

    Bucket createBucket(String bucket);

}
