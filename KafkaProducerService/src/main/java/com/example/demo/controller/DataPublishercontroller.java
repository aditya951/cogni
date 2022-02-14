package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.DataPublisher;

@RestController
@RequestMapping("/publisher")
public class DataPublishercontroller {

	
	@Autowired
	DataPublisher dataPublisher;
	
	
	@PostMapping("/publish")
	public void publishing(@RequestParam("msg") String msg) {
		
		dataPublisher.setTemp(msg);
	}
	
}
