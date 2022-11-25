package com.liquido;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@MapperScan("com.liquido.mapper") //扫描的mapper
@SpringBootApplication
@Slf4j
public class CustomerApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(CustomerApplication.class);
		Environment env = app.run(args).getEnvironment();
		log.info("启动成功！！");
		log.info("测试地址: http://127.0.0.1:{}", env.getProperty("server.port"));
	}
}
