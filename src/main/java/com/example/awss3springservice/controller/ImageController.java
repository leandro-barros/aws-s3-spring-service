package com.example.awss3springservice.controller;

import com.amazonaws.services.s3.model.Bucket;
import com.example.awss3springservice.service.BucketService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/images")
public class ImageController {

    private final BucketService bucketService;

    @GetMapping("/buckets")
    public ResponseEntity<List<Bucket>> listOfBuckets() {
        return ResponseEntity.ok(bucketService.listOfBuckets());
    }

}
