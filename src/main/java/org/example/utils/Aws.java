package org.example.utils;


import jakarta.servlet.http.Part;
import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;
import software.amazon.awssdk.services.s3.presigner.model.GetObjectPresignRequest;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.time.Duration;

public class Aws {

    private S3Client connectS3Client() {
        return S3Client.builder()
                .region(Region.AP_SOUTHEAST_1)
                .credentialsProvider(ProfileCredentialsProvider.create(Constant.AWS.PROFILE_AUTHENTICATION))
                .build();
    }

    private S3Presigner connectS3() {
        return S3Presigner.builder()
                .region(Region.AP_SOUTHEAST_1)
                .credentialsProvider(ProfileCredentialsProvider.create(Constant.AWS.PROFILE_AUTHENTICATION))
                .build();
    }

    public void uploadFile(String key, Part filePart) throws IOException {
        try (S3Client s3 = connectS3Client()) {
            s3.putObject(
                    PutObjectRequest.builder()
                            .bucket(Constant.AWS.BUCKET_IMAGE_CATEGORY)
                            .key(key)
                            .contentType(filePart.getContentType())
                            .build(),
                    RequestBody.fromInputStream(filePart.getInputStream(), filePart.getSize())
            );
            System.out.println("✅ Uploaded " + key + " successfully");
        }
    }

    public File downloadFile(String key, String localPath) throws IOException {
        File downloaded = new File(localPath);
        try (S3Client s3 = connectS3Client()) {
            s3.getObject(
                    GetObjectRequest.builder()
                            .bucket(Constant.AWS.BUCKET_IMAGE_CATEGORY)
                            .key(key)
                            .build(),
                    downloaded.toPath()
            );
        }
        return downloaded;
    }


    /**
     * Tạo URL tạm thời để truy cập file (GET)
     */
    public String generatePresignedGetUrl(String key) {
        S3Presigner presigner = connectS3();

        GetObjectRequest getObjectRequest = GetObjectRequest.builder()
                .bucket(Constant.AWS.BUCKET_IMAGE_CATEGORY)
                .key(key)
                .build();

        GetObjectPresignRequest presignRequest = GetObjectPresignRequest.builder()
                .signatureDuration(Duration.ofHours(1)) // URL có hiệu lực 1 tiếng
                .getObjectRequest(getObjectRequest)
                .build();

        String url = presigner.presignGetObject(presignRequest).url().toString();
        presigner.close();
        return url;
    }
}
