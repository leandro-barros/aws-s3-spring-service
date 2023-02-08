package com.example.awss3springservice.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmazonConfig {

    private String awsAccessKey;

    private String awsSecretKey;

    @Bean
    public AmazonS3 amazonS3Config() {
        BasicAWSCredentials basicAWSCredentials = new BasicAWSCredentials("AKIAQNSVT6BXIPL5FBVR", "2QwuXbgcIkbcosx7Eba76qR8esmOm5De4ztv4DNJ");

        return AmazonS3ClientBuilder
                .standard()
                .withRegion(Regions.DEFAULT_REGION)
                .withCredentials(new AWSStaticCredentialsProvider(basicAWSCredentials))
                .build();
    }

}
