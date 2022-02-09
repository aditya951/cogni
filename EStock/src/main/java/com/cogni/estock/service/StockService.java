package com.cogni.estock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cogni.estock.model.Company;
import com.cogni.estock.repository.StockRepository;

@Service
public class StockService {

	@Autowired
	private StockRepository stockRepository;
	
	
	public List<Company> getAllStock(){
		List<Company> stockList = stockRepository.findAll();
	return stockList;
	
	}
	
	public Company addStock(Company stock){
		if(stock.getCompanyTurnover()>=100000000) {
			return stockRepository.save(stock);
		}
		return new Company();
	
	}
	
	public boolean deleteStock(int id) {
		stockRepository.deleteById(id);
		return true;
	}
	
	public boolean updateStock(Company stock) {
		
		Company stock1 = stockRepository.getById(stock.getCompanyCode());
		
		if(stock1!=null) {
			stock1.setCompanyCEO(stock.getCompanyCEO());
			stock1.setCompanyName(stock.getCompanyName());
			stock1.setCompanyTurnover(stock.getCompanyTurnover());
			stock1.setCompanyWebsite(stock.getCompanyWebsite());
			stock1.setStockExchangeName(stock.getStockExchangeName());
			stockRepository.saveAndFlush(stock1);
			
		}
		
		return true;
	}
	
}
