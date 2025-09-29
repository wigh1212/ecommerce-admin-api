package org.eppay.api;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@EnableEncryptableProperties
public class EpPayApiApplication  extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(EpPayApiApplication.class, args);
	}

}
