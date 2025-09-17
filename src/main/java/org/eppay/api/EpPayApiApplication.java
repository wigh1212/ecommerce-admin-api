package org.eppay.api;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEncryptableProperties
public class EpPayApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EpPayApiApplication.class, args);
	}

}
