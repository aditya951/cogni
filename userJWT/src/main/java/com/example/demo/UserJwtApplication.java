package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.example.demo.filter.JWTFilter;

@SpringBootApplication
public class UserJwtApplication {

	@Bean
	public FilterRegistrationBean jwtFilter() {
		FilterRegistrationBean fb = new FilterRegistrationBean();
		fb.setFilter(new JWTFilter());
		fb.addUrlPatterns("/api/v1/*","/api/v1.0/market/*");
		return fb;
	}

	public static void main(String[] args) {
		SpringApplication.run(UserJwtApplication.class, args);
	}

}
