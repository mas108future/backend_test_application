package com.zinger.examback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class ZingerExamAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZingerExamAppApplication.class, args);
	}

}
