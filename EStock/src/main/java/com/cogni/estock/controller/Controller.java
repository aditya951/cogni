package com.cogni.estock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cogni.estock.model.Stock;
import com.cogni.estock.service.StockService;

@RestController
public class Controller {

	@Autowired
	StockService stockService;
	
	@GetMapping("hello")
	public String hello() {
		return "hello Aditya";
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAll(){
		List<Stock> allStock = stockService.getAllStock();
		
		return new ResponseEntity<List<Stock>>(allStock,HttpStatus.OK);
	}
	
	@PostMapping(value="/addstock")
	public ResponseEntity<?> addStock(@RequestBody Stock stock){
		if(stockService.addStock(stock)!=null)
		return new ResponseEntity<Stock>(stock,HttpStatus.CREATED);
	
		return new ResponseEntity<String>("no data",HttpStatus.CONFLICT);
	}
	
	
	
	
}
