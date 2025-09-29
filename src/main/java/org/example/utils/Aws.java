package org.example.utils;


import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;
import software.amazon.awssdk.services.s3.presigner.model.GetObjectPresignRequest;

import java.time.Duration;

public class Aws {
    private S3Presigner connectS3() {
        Region region = Region.US_EAST_1;
        // 2️⃣ Create S3Presigner using a profile (can be IAM user or SSO)
        return S3Presigner.builder()
                .region(region)
                .credentialsProvider(ProfileCredentialsProvider.create(Constant.AWS.PROFILE_AUTHENTICATION)) // your profile
                .build();
    }

    public String getImageCategoryLink(String image) {
        S3Presigner s3 = connectS3();

        GetObjectRequest getObjectRequest = GetObjectRequest.builder()
                .bucket(Constant.AWS.BUCKET_IMAGE_CATEGORY)
                .key(image)
                .build();

        GetObjectPresignRequest presignRequest = GetObjectPresignRequest.builder()
                .signatureDuration(Duration.ofHours(1))
                .getObjectRequest(getObjectRequest)
                .build();
        return s3.presignGetObject(presignRequest).url().toString();
    }
}
