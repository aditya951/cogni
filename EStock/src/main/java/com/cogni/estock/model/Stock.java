package com.cogni.estock.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;


@Entity
public class Stock {
	
	@Id
	@GeneratedValue
	private long id;
	
	private double stockPrice;
	//@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss")
	@CreationTimestamp
	private LocalDateTime date;
	
//	@ManyToOne
//	private Company company;
	
	
	public Stock() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public Stock(long id, double stockPrice, LocalDateTime date, Company comapany) {
		super();
		this.id = id;
		this.stockPrice = stockPrice;
		this.date = date;
		//this.company = company;
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}


//
//	public Company getComapany() {
//		return company;
//	}
//
//
//
//	public void setComapany(Company company) {
//		this.company = company;
//	}



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
		return "Stock [id=" + id + ", stockPrice=" + stockPrice + ", date=" + date + "]";
	}

	
	

}
