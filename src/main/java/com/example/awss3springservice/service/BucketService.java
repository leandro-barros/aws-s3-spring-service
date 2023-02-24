package com.example.awss3springservice.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.services.s3.model.Bucket;
import com.example.awss3springservice.config.AmazonConfig;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Slf4j
@Service
public class BucketService {

    private final AmazonConfig amazonConfig;

    public Bucket findBucket(String bucketName) {
        List<Bucket> buckets = amazonConfig.amazonS3Config().listBuckets();
        for (Bucket bucket: buckets) {
            if (bucket.getName().equals(bucketName)) {
                return bucket;
            }
        }

        return null;
    }

    public List<Bucket> listOfBuckets() {
        List<Bucket> buckets = amazonConfig.amazonS3Config().listBuckets();
        log.info("List of buckets on your account.");

        for (Bucket bucket: buckets) {
            System.out.format("-> %s\n", bucket.getName());
        }

        return buckets;
    }

    public Bucket createBucket(String bucket) {
        final AmazonS3 s3 = amazonConfig.amazonS3Config();
        Bucket newBucket = null;

        boolean doesExist = s3.doesBucketExistV2(bucket);
        if (doesExist) {
            try {
                newBucket = findBucket(bucket);
            } catch (AmazonS3Exception e){
                log.info("Error in find bucket.");
            }
            return newBucket;
        }

        try {
            newBucket = s3.createBucket(bucket);
        } catch (AmazonS3Exception e) {
            log.info("Error in to create bucket: {}", bucket);
        }

        return newBucket;
    }

}
