package com.cogni.estock.controller;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cogni.estock.model.Company;
import com.cogni.estock.model.Stock;
import com.cogni.estock.response.ResponseHandler;
import com.cogni.estock.service.StockService;

@RestController
@RequestMapping("api/v1.0/market")
@CrossOrigin(origins="http://localhost:4200/")
public class Controller {

	@Autowired
	StockService stockService;

	@GetMapping("/hello")
	public String hello() {
		return "hello Aditya";
	}

	@GetMapping("/company/getall")
	public ResponseEntity<?> getAll() {
		List<Company> allStock = stockService.getAllStock();

//		if (allStock != null) {
//			CacheControl cacheControl = CacheControl.maxAge(30, TimeUnit.MINUTES);

			// return ResponseEntity.ok().cacheControl(cacheControl).body(allStock);
//			return ResponseEntity.ok().cacheControl(cacheControl)
//					.body(ResponseHandler.generateResponse("successfully retrieved data ", HttpStatus.OK, allStock));
//		}
		return new ResponseEntity<List<Company>>(allStock, HttpStatus.OK);
		
//		return new ResponseEntity<String>("CompanyList is empty", HttpStatus.NO_CONTENT);

	}

	@GetMapping("/company/info/{cid}")
	public ResponseEntity<?> getcompany(@PathVariable("cid") int cid) {
		Company companyInfo = stockService.getCompanyInfo(cid);

		return new ResponseEntity<Company>(companyInfo,HttpStatus.OK);
		//return ResponseHandler.generateResponse("successfully retrieved data ", HttpStatus.OK, companyInfo);

	}

	
	@GetMapping("/company/info/name/{cname}")
	public ResponseEntity<?> getcompanybyname(@PathVariable("cname") String cname) {
		Company companyInfo = stockService.getCompanyInfoByName(cname);

		 return new ResponseEntity<Company>(companyInfo,HttpStatus.OK);
		//return ResponseHandler.generateResponse("successfully retrieved data ", HttpStatus.OK, companyInfo);

	}
	
	
	@PostMapping(value = "/company/register")
	public ResponseEntity<?> addStock(@RequestBody Company stock) {
		if (stockService.addStock(stock) != null)
			return new ResponseEntity<Company>(stock, HttpStatus.CREATED);

		return new ResponseEntity<String>("no data", HttpStatus.CONFLICT);
	}

	@DeleteMapping("/company/delete/{cid}")
	public ResponseEntity<?> deleteStock(@PathVariable("cid") int cid) {

		if (stockService.deleteStock(cid)) {
			return new ResponseEntity<String>("Record deleted", HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<String>("cannot delete due to internal error", HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@PutMapping("/update")
	public ResponseEntity<?> updateStock(@RequestBody Company stock) {

		if (stockService.updateStock(stock))
			return new ResponseEntity<Company>(stock, HttpStatus.CREATED);

		return new ResponseEntity<String>("update unsuccessfull", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@PutMapping("/stock/put/{cid}")
	public ResponseEntity<?> updateStock(@RequestBody Stock stock, @PathVariable("cid") int cid) {

		if (stockService.updateStockbyID(stock, cid))
			return new ResponseEntity<Stock>(stock, HttpStatus.CREATED);

		return new ResponseEntity<String>("update unsuccessfull", HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
