package com.cogni.estock.controller;

import java.net.URI;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cogni.estock.model.User;

@RestController
@RequestMapping("auth/v1")
public class JWTController {

	@Autowired
	private DiscoveryClient discoveryClient;
	
	@GetMapping("/")
	public ResponseEntity<?> getAll(){
//		List<Company> allStock = stockService.getAllStock();
//		
//		return new ResponseEntity<List<Company>>(allStock,HttpStatus.OK);

		List<ServiceInstance> instances = discoveryClient.getInstances("jwt-consumer");

		ServiceInstance serviceInstance = instances.get(0);

		String baseUrl = serviceInstance.getUri().toString();

		RestTemplate restTemplate = new RestTemplate();

		baseUrl = baseUrl + "/auth/v1/";// http://localhost:8083/auth/v1/
		//http://localhost:8083/auth/v1/

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
	
	
	
	@PostMapping("/login")
	public ResponseEntity<?> doLogin(@RequestBody User user) {
		List<ServiceInstance> instances = discoveryClient.getInstances("jwt-consumer");

		ServiceInstance serviceInstance = instances.get(0);

		String baseUrl = serviceInstance.getUri().toString();

		RestTemplate restTemplate = new RestTemplate();

		baseUrl = baseUrl + "/auth/v1/login";// http://localhost:8083/auth/v1/login
		//http://localhost:8083/auth/v1/login
		 
		ResponseEntity<String> response = null;

		try {
			URI uri = new URI(baseUrl);
			//response = restTemplate.exchange(baseUrl, HttpMethod.GET, getHeaders(), String.class);
			 response = restTemplate.postForEntity(uri, user, String.class);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(response.getBody());
		System.out.println(response.getHeaders() + "::" + response.getStatusCode());
	
		return response;
			

		//return new ResponseEntity<>(map, HttpStatus.OK);
	}
	
	private static HttpEntity<?> getHeaders() throws Exception {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		return new HttpEntity<>(headers);
	}
	
}
