package com.cogni.estock.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cogni.estock.model.Stock;


@Repository
@Transactional
public interface StockRepository extends JpaRepository<Stock, Integer> {
	

}
