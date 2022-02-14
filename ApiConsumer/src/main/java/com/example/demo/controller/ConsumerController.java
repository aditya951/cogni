package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;



@RestController
public class ConsumerController {
	@Autowired
	private DiscoveryClient discoveryClient;

	public void getStocks() throws RestClientException, Exception {

		List<ServiceInstance> instances = discoveryClient.getInstances("stock-producer");

		ServiceInstance serviceInstance = instances.get(0);

		String baseUrl = serviceInstance.getUri().toString();

		RestTemplate restTemplate = new RestTemplate();

		baseUrl = baseUrl + "/api/v1.0/market/company/getall";// http://localhost:8082/api/v1/getAllBooks
		//http://localhost:8082/api/v1.0/market/company/getall

		ResponseEntity<String> response = null;

		try {
			response = restTemplate.exchange(baseUrl, HttpMethod.GET, getHeaders(), String.class);

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(response.getBody());
		System.out.println(response.getHeaders() + "::" + response.getStatusCode());

	}

	private static HttpEntity<?> getHeaders() throws Exception {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		return new HttpEntity<>(headers);
	}
	
	
	
	@GetMapping("api/v1.0/market/company/getall")
	public ResponseEntity<?> getAll(){
//		List<Company> allStock = stockService.getAllStock();
//		
//		return new ResponseEntity<List<Company>>(allStock,HttpStatus.OK);

		List<ServiceInstance> instances = discoveryClient.getInstances("stock-producer");

		ServiceInstance serviceInstance = instances.get(0);

		String baseUrl = serviceInstance.getUri().toString();

		RestTemplate restTemplate = new RestTemplate();

		baseUrl = baseUrl + "/api/v1.0/market/company/getall";// http://localhost:8082/api/v1/getAllBooks
		//http://localhost:8082/api/v1.0/market/company/getall

		ResponseEntity<String> response = null;

		try {
			response = restTemplate.exchange(baseUrl, HttpMethod.GET, getHeaders(), String.class);

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(response.getBody());
		System.out.println(response.getHeaders() + "::" + response.getStatusCode());
	
		return response;
	}
}
