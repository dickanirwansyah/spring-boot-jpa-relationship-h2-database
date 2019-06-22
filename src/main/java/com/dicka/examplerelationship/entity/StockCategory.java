package com.dicka.examplerelationship.entity;

import lombok.Data;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "stock_category")
@AssociationOverrides({
        @AssociationOverride(name = "pk.stock", joinColumns = @JoinColumn(name = "stock_id")),
        @AssociationOverride(name = "pk.category", joinColumns = @JoinColumn(name = "category_id"))
})
public class StockCategory implements Serializable{

    @EmbeddedId
    private StockCategoryId pk = new StockCategoryId();

    @Temporal(TemporalType.DATE)
    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "created_by")
    private String createdBy;

    @Transient
    public Stock getStock(){
        return getPk().getStock();
    }

    public void setStock(Stock stock){
        getPk().setStock(stock);
    }

    @Transient
    public Category getCategory(){
        return getPk().getCategory();
    }

    public void setCategory(Category category){
        getPk().setCategory(category);
    }

    public StockCategoryId getPk() {
        return pk;
    }

    public void setPk(StockCategoryId pk) {
        this.pk = pk;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
}
