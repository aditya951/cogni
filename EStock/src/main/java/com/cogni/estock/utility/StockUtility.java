package com.cogni.estock.utility;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cogni.estock.model.Company;
import com.cogni.estock.model.Stock;

@Component
public class StockUtility {

	public List<Company> findLatest(List<Company> cp) {

		List<Company> list = new ArrayList<>();

		for (Company c : cp) {

			Company cmp=new Company();
			cmp.setCompanyCode(c.getCompanyCode());
			cmp.setCompanyName(c.getCompanyName());
			cmp.setCompanyCEO(c.getCompanyCEO());
			cmp.setCompanyTurnover(c.getCompanyTurnover());
			cmp.setCompanyWebsite(c.getCompanyWebsite());
			cmp.setStockExchangeName(c.getStockExchangeName());
			
			
			List<Stock> s=new ArrayList<>();
//			LocalDateTime max;
			
			if (c.getStocks() != null && !c.getStocks().isEmpty()) {
				c.getStocks().sort(Comparator.comparing(Stock::getDate).reversed());
				Stock stock = c.getStocks().get(0);
				
				s.add(stock);
				cmp.setStocks(s);
				
//				List<LocalDateTime> list1 = new ArrayList<>();
//				Stock sto=new Stock();
//				for (Stock stock : stocks) {
//						
//					if (stock.getDate() != null)
//						list1.add(stock.getDate());
//				}
//				 max = Collections.max(list1);
//				 sto.setDate(max);
//				 s.add(sto);
			}
			cmp.setStocks(s);
			
			list.add(cmp);
		}
		return list;
	}
}
