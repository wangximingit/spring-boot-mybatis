package com.projects.neo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@MapperScan(value = "com.projects.neo.api.dao")
//启注解事务管理
@EnableTransactionManagement
@EnableScheduling

public class NeoApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(NeoApplication.class, args);
	}

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(NeoApplication.class);
	}
}
