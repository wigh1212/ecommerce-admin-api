package org.eppay.api.config;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEBigDecimalEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@EnableEncryptableProperties
public class JasyptConfig {
    @Bean("jasyptStringEncryptor")
    @Primary
    public StringEncryptor stringEncryptor(){

        PooledPBEStringEncryptor encryptor=new PooledPBEStringEncryptor();

        SimpleStringPBEConfig config=new SimpleStringPBEConfig();

        String password=System.getProperty("jasypt.encryptor.password",System.getenv("JASYPT_ENCRYPTOR_PASSWORD"));
        config.setPassword(password);
        config.setAlgorithm("PBEWithMD5AndDES");
        config.setKeyObtentionIterations("1000");
        config.setPoolSize(1);
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setStringOutputType("base64");

        encryptor.setConfig(config);
        return encryptor;
    }
}
