package com.cogni.estock.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;


@Entity
public class Stock {
	
	
	@Id
	private int companyCode; 
	private String companyName; 
	private String companyCEO; 
	private long companyTurnover; 
	private String companyWebsite; 
	private String stockExchangeName;
	private double stockPrice;
	//@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss")
	@CreationTimestamp
	private LocalDateTime date;
	
	public Stock() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Stock(int companyCode, String companyName, String companyCEO, long companyTurnover, String companyWebsite,
			String stockExchangeName, double stockPrice, LocalDateTime date) {
		super();
		this.companyCode = companyCode;
		this.companyName = companyName;
		this.companyCEO = companyCEO;
		this.companyTurnover = companyTurnover;
		this.companyWebsite = companyWebsite;
		this.stockExchangeName = stockExchangeName;
		this.stockPrice = stockPrice;
		this.date = date;
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

	public double getStockPrice() {
		return stockPrice;
	}

	public void setStockPrice(double stockPrice) {
		this.stockPrice = stockPrice;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Stock [companyCode=" + companyCode + ", companyName=" + companyName + ", companyCEO=" + companyCEO
				+ ", companyTurnover=" + companyTurnover + ", companyWebsite=" + companyWebsite + ", stockExchangeName="
				+ stockExchangeName + ", stockPrice=" + stockPrice + ", date=" + date + "]";
	}
	
	
	
	
	
	
}
