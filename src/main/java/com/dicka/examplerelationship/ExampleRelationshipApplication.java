package com.dicka.examplerelationship;

import com.dicka.examplerelationship.entity.Category;
import com.dicka.examplerelationship.entity.Stock;
import com.dicka.examplerelationship.entity.StockCategory;
import com.dicka.examplerelationship.repository.CategoryRepo;
import com.dicka.examplerelationship.repository.StockRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.Date;

@SpringBootApplication
public class ExampleRelationshipApplication {


	public static void main(String[] args) {
		SpringApplication.run(ExampleRelationshipApplication.class, args);
	}

}

@Component
class CommandDataExecute implements CommandLineRunner{

	@Autowired
	private CategoryRepo categoryRepo;

	@Autowired
	private StockRepo stockRepo;

	@Override
	public void run(String... args) throws Exception {

		Stock stock = new Stock();
		stock.setStockCode("stock001");
		stock.setStockName("stock name 1");

		Category category = new Category();
		category.setCategoryName("category name 1");
		category.setCategoryDesc("categor description 1");
		categoryRepo.save(category);

		StockCategory stockCategory = new StockCategory();
		stockCategory.setCategory(category);
		stockCategory.setStock(stock);
		stockCategory.setCreatedBy("System");
		stockCategory.setCreatedDate(new Date());

		stock.getStockCategories().add(stockCategory);
		stockRepo.save(stock);

	}
}