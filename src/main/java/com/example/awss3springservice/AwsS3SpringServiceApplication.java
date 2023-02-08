package com.example.awss3springservice;

import com.example.awss3springservice.service.BucketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AwsS3SpringServiceApplication {



	public static void main(String[] args) {
		SpringApplication.run(AwsS3SpringServiceApplication.class, args);
		BucketService bucketService = new BucketService();
		bucketService.createBucket("Bucket07");
	}

}
