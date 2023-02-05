package com.example.awss3springservice.service;

import com.amazonaws.services.s3.model.Bucket;
import com.example.awss3springservice.config.AmazonConfig;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BucketService {

    @Autowired
    private AmazonConfig amazonConfig;

    public Bucket findBucket(String bucketName) {
        List<Bucket> buckets = amazonConfig.amazonS3Config().listBuckets();
        for (Bucket bucket: buckets) {
            if (bucket.getName().equals(bucketName)) {
                return bucket;
            }
        }

        return null;
    }

}
