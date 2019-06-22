package com.dicka.examplerelationship.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "category")
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private int categoryId;

    @Column(name = "category_name")
    private String categoryName;

    @Column(name = "category_desc")
    private String categoryDesc;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.category", cascade = CascadeType.ALL)
    private Set<StockCategory> stockCategories = new HashSet<>();

    public Category() {

    }

    public Category(int categoryId, String categoryName, String categoryDesc, Set<StockCategory> stockCategories) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryDesc = categoryDesc;
        this.stockCategories = stockCategories;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDesc() {
        return categoryDesc;
    }

    public void setCategoryDesc(String categoryDesc) {
        this.categoryDesc = categoryDesc;
    }

    public Set<StockCategory> getStockCategories() {
        return stockCategories;
    }

    public void setStockCategories(Set<StockCategory> stockCategories) {
        this.stockCategories = stockCategories;
    }
}
