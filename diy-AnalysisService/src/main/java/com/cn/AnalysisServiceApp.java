package com.cn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class AnalysisServiceApp {
	public static void main(String[] args) {
		SpringApplication.run(AnalysisServiceApp.class, args);
		System.out.println("消费者启动成功，端口号："+8763);
	}
}
