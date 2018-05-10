package io.namoo.metro.ra.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

//@EntityScan
@SpringBootApplication
public class SpringBootTestApplication {
	//
	public static void main(String[] args) {
		SpringApplication.run(SpringBootTestApplication.class, args);
	}
}