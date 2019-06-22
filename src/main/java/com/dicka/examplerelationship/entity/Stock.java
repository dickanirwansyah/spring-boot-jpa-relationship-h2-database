package com.dicka.examplerelationship.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "stock")
public class Stock implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stock_id")
    private int stockId;

    @Column(name = "stock_code")
    private String stockCode;

    @Column(name = "stock_name")
    private String stockName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.stock", cascade = CascadeType.ALL)
    private Set<StockCategory> stockCategories = new HashSet<>();

    public Stock(){}

    public Stock(int stockId, String stockCode, String stockName, Set<StockCategory> stockCategories) {
        this.stockId = stockId;
        this.stockCode = stockCode;
        this.stockName = stockName;
        this.stockCategories = stockCategories;
    }

    public int getStockId() {
        return stockId;
    }

    public void setStockId(int stockId) {
        this.stockId = stockId;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public Set<StockCategory> getStockCategories() {
        return stockCategories;
    }

    public void setStockCategories(Set<StockCategory> stockCategories) {
        this.stockCategories = stockCategories;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "stockId=" + stockId +
                ", stockCode='" + stockCode + '\'' +
                ", stockName='" + stockName + '\'' +
                ", stockCategories=" + stockCategories +
                '}';
    }
}
