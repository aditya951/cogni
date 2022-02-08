package com.cogni.estock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cogni.estock.model.Stock;
import com.cogni.estock.repository.StockRepository;

@Service
public class StockService {

	@Autowired
	private StockRepository stockRepository;
	
	
	public List<Stock> getAllStock(){
		List<Stock> stockList = stockRepository.findAll();
	return stockList;
	
	}
	
	public Stock addStock(Stock stock){
	  return stockRepository.saveAndFlush(stock);
	
	
	}
}
