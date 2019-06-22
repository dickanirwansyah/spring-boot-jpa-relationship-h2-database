package com.dicka.examplerelationship.repository;

import com.dicka.examplerelationship.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepo extends JpaRepository<Stock, Integer> {
}
