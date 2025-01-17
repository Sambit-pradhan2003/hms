package com.hms.ThirdpartyService;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Service
public class S3Bucketservice {
    private final AmazonS3 amazonS3;

    @Value("${amazon.s3.bucket}")
    private String bucketName;

    public S3Bucketservice(AmazonS3 amazonS3) {
        this.amazonS3 = amazonS3;
    }

    public String uploadFile( MultipartFile file) throws  IOException {
        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();

        try (InputStream inputStream = file.getInputStream()) {
            amazonS3.putObject(new PutObjectRequest(bucketName, fileName, inputStream, null));
        }

        return amazonS3.getUrl(bucketName, fileName).toString();
    }

    }
