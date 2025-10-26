package org.example;

import org.example.utils.Aws;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

public class AwsTest {
    @Test
    public void testUpdateImageCategory() throws IOException {
        Aws aws = new Aws();
        String image = "avatar.png";
        File file = new File("src/test/resources/image/" + image);
//        aws.uploadFile(image, file);
    }

    @Test
    public void generatePresignedUrl() throws IOException {
        Aws aws = new Aws();
        String urlPrivate = aws.generatePresignedGetUrl("avatar.png");
        System.out.println(urlPrivate);
    }
}
