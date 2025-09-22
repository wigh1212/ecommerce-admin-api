package org.eppay.api.config;

import lombok.Getter;
import lombok.Setter;
import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;


//aws.s3.key=
//
//aws.s3.secret=
//
//aws.s3.bucket=


@Configuration
@Getter
@Setter
//@ConfigurationProperties(prefix = "aws.s3")
public class S3Config {

    // application.properties에서 그대로 읽음 (암호화된 값)
    @Value("${aws.s3.key}")
    private String key;

    @Value("${aws.s3.secret}")
    private String secret;

    @Value("${aws.s3.bucket}")
    private String bucket;

    @Value("${aws.s3.region}")
    private String region;

    @Value("${spring.datasource.username}")
    private String dbname;

    @Autowired
    private StringEncryptor encryptor;



    @Bean
    public S3Client s3Client() {
        return S3Client.builder()
                .region(Region.of(region))
                .credentialsProvider(
                        StaticCredentialsProvider.create(
                                AwsBasicCredentials.create(key, secret)
                        )
                )
                .build();
    }

}