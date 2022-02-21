package com.cogni.estock.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;




@Entity
public class Company {
	
	
	@Id
	@GeneratedValue
	private int companyCode; 
	private String companyName; 
	private String companyCEO; 
	private long companyTurnover; 
	private String companyWebsite; 
	private String stockExchangeName;
	
	@OneToMany(cascade = CascadeType.ALL)//(mappedBy="company")
	private List<Stock> stocks=new ArrayList<>();
	
	
	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Company(int companyCode, String companyName, String companyCEO, long companyTurnover, String companyWebsite,
			String stockExchangeName, double stockPrice, LocalDateTime date) {
		super();
		this.companyCode = companyCode;
		this.companyName = companyName;
		this.companyCEO = companyCEO;
		this.companyTurnover = companyTurnover;
		this.companyWebsite = companyWebsite;
		this.stockExchangeName = stockExchangeName;
		
	}
	
	

	public Company(int companyCode, String companyName, String companyCEO, long companyTurnover, String companyWebsite,
			String stockExchangeName, List<Stock> stocks) {
		super();
		this.companyCode = companyCode;
		this.companyName = companyName;
		this.companyCEO = companyCEO;
		this.companyTurnover = companyTurnover;
		this.companyWebsite = companyWebsite;
		this.stockExchangeName = stockExchangeName;
		this.stocks = stocks;
	}

	public int getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(int companyCode) {
		this.companyCode = companyCode;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyCEO() {
		return companyCEO;
	}

	public void setCompanyCEO(String companyCEO) {
		this.companyCEO = companyCEO;
	}

	public long getCompanyTurnover() {
		return companyTurnover;
	}

	public void setCompanyTurnover(long companyTurnover) {
		this.companyTurnover = companyTurnover;
	}

	public String getCompanyWebsite() {
		return companyWebsite;
	}

	public void setCompanyWebsite(String companyWebsite) {
		this.companyWebsite = companyWebsite;
	}

	public String getStockExchangeName() {
		return stockExchangeName;
	}

	public void setStockExchangeName(String stockExchangeName) {
		this.stockExchangeName = stockExchangeName;
	}

	
	
	public List<Stock> getStocks() {
		return stocks;
	}

	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
	}

	@Override
	public String toString() {
		return "Company [companyCode=" + companyCode + ", companyName=" + companyName + ", companyCEO=" + companyCEO
				+ ", companyTurnover=" + companyTurnover + ", companyWebsite=" + companyWebsite + ", stockExchangeName="
				+ stockExchangeName + ", stocks=" + stocks + "]";
	}

	

	
	
	
	
	
	
}
