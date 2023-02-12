package com.example.awss3springservice.controller;

import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.ListObjectsV2Result;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.example.awss3springservice.service.BucketService;
import com.example.awss3springservice.service.ObjectS3Service;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/images")
public class ImageController {

    private final BucketService bucketService;

    private final ObjectS3Service objectS3Service;

    @GetMapping("/buckets")
    public ResponseEntity<List<Bucket>> listOfBuckets() {
        return ResponseEntity.ok(bucketService.listOfBuckets());
    }

    @GetMapping("/buckets/{bucketName}")
    public ResponseEntity<Bucket> findBucketByName(@PathVariable String bucketName) {
        return ResponseEntity.ok(bucketService.findBucket(bucketName));
    }

    @GetMapping("/buckets/{bucketName}/objects")
    public ResponseEntity<List<S3ObjectSummary>> listObjects(@PathVariable String bucketName) {
        return ResponseEntity.ok(objectS3Service.listObjectsS3(bucketName));
    }

}
