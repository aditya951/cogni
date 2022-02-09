package com.cogni.estock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cogni.estock.model.Company;
import com.cogni.estock.service.StockService;

@RestController
@RequestMapping("api/v1.0/market")
public class Controller {

	@Autowired
	StockService stockService;
	
	@GetMapping("hello")
	public String hello() {
		return "hello Aditya";
	}
	
	@GetMapping("/company/getall")
	public ResponseEntity<?> getAll(){
		List<Company> allStock = stockService.getAllStock();
		
		return new ResponseEntity<List<Company>>(allStock,HttpStatus.OK);
	}
	
	@PostMapping(value="/company/register")
	public ResponseEntity<?> addStock(@RequestBody Company stock){
		if(stockService.addStock(stock)!=null)
		return new ResponseEntity<Company>(stock,HttpStatus.CREATED);
	
		return new ResponseEntity<String>("no data",HttpStatus.CONFLICT);
	}
	
	
	@DeleteMapping("/company/delete/{cid}")
	 public ResponseEntity<?> deleteStock(@PathVariable("cid") int cid){
		
		if(stockService.deleteStock(cid))
		{
			return new ResponseEntity<String>("Record delgeted",HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<String>("cannot delete due to internal error",HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	
	@PutMapping("/update")
	public ResponseEntity<?> updateStock(@RequestBody Company stock){
		
		if(stockService.updateStock(stock))
		return new ResponseEntity<Company>(stock,HttpStatus.CREATED);
	
		return new ResponseEntity<String>("update unsuccessfull",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	
	
	
	
	
	
}
