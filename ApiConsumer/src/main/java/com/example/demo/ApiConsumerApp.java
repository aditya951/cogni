package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClientException;

import com.example.demo.controller.ConsumerController;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiConsumerApp {

	public static void main(String[] args) throws RestClientException, Exception {
		ApplicationContext ctx = SpringApplication.run(ApiConsumerApp.class, args);
		ConsumerController consumerController = ctx.getBean(ConsumerController.class);
		consumerController.getStocks();
	}

	@Bean
	public ConsumerController consumerController() {
		return new ConsumerController();
	}
}