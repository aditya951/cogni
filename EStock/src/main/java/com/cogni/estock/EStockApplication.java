package com.cogni.estock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import com.cogni.estock.jwtfilter.JWTFilter;

@SpringBootApplication
//@EnableDiscoveryClient
//@EnableEurekaClient
public class EStockApplication {

//	
//	@Bean
//	public FilterRegistrationBean jwtFilter() {
//		FilterRegistrationBean fb = new FilterRegistrationBean();
//		fb.setFilter(new JWTFilter());
//		fb.addUrlPatterns("/api/v1/*","/api/v1.0/market/*");
//		return fb;
//	}
	
	public static void main(String[] args) {
		SpringApplication.run(EStockApplication.class, args);
	}

}
