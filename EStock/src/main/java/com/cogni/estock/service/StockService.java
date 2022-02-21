package com.cogni.estock.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cogni.estock.exception.CustomException;
import com.cogni.estock.model.Company;
import com.cogni.estock.model.Stock;
import com.cogni.estock.repository.StockRepository;
import com.cogni.estock.utility.StockUtility;

@Service
public class StockService {

	@Autowired
	private StockRepository stockRepository;
	
	@Autowired
	private StockUtility stockUtility;

	public List<Company> getAllStock() {
		List<Company> stockList = stockRepository.findAll();
		
		List<Company> findLatest = stockUtility.findLatest(stockList);
		//System.out.println(findLatest +" aditya");
		return findLatest;

	}

	public Company addStock(Company stock) {

		Company findBycompanyName = stockRepository.findBycompanyName(stock.getCompanyName());

		if (findBycompanyName!=null) {
			throw new CustomException("company already exist");
		} else {

			if (stock.getCompanyTurnover() >= 100000000) {
				return stockRepository.save(stock);
			}else {
				throw new CustomException("turnover is less than 10 cr");
			}
			
		}
	}

	public Company getCompanyInfo(int cid) {
		Optional<Company> details = stockRepository.findById(cid);
		
		if (details.isPresent()) {
			 Company company = details.get();
			 company.getStocks().sort(Comparator.comparing(Stock::getDate).reversed());
			 return company;
		} else {
			throw new CustomException("ID not found");
		}
	}

	public boolean deleteStock(int id) {
Optional<Company> details = stockRepository.findById(id);
		
		if (details.isPresent()) {
			stockRepository.deleteById(id);
			return true;
		} else {
			throw new CustomException("ID not found");
		}
		
		
//		stockRepository.deleteById(id);
//		return true;
	}

	public boolean updateStock(Company stock) {

		Company stock1 = stockRepository.getById(stock.getCompanyCode());

		if (stock1 != null) {
			stock1.setCompanyCEO(stock.getCompanyCEO());
			stock1.setCompanyName(stock.getCompanyName());
			stock1.setCompanyTurnover(stock.getCompanyTurnover());
			stock1.setCompanyWebsite(stock.getCompanyWebsite());
			stock1.setStockExchangeName(stock.getStockExchangeName());
//			List<Stock> stocksfromdb = stock1.getStocks();
//			List<Stock> stocks2 = stock.getStocks();
//			stocksfromdb.addAll(stocks2);
//			stock1.setStocks(stocksfromdb);
			stockRepository.save(stock1);

		}

		return true;
	}

	public boolean updateStockbyID(Stock stock, int cid) {

		Company stock1 = stockRepository.findById(cid).get();

		if (stock1 != null) {

			List<Stock> stocksfromdb = stock1.getStocks();
			stocksfromdb.add(stock);
			stock1.setStocks(stocksfromdb);
			stockRepository.save(stock1);

		}

		return true;
	}
	
	
	public Company getCompanyInfoByName(String cname) {
		Company findBycompanyName = stockRepository.findBycompanyName(cname);
		
		if (findBycompanyName!=null) {
			return findBycompanyName;
		} else {
			throw new CustomException("Company Not found");
		}
	}

}
