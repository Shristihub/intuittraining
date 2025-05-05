package com.productcatalog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.productcatalog.model.Product;
@Repository
public interface IProductRepository extends JpaRepository<Product, Integer>{

	List<Product> findByBrand(String brand);
	
	@Query(value = "from Product p where p.category=?1 and p.price<?2")
	List<Product> findByCatPrice(String category,double price);
	
	@Query(value = "from Product p where p.productName like:productName and price<:price")
	List<Product> findByNamePrice(@Param("productName") String name,@Param("price") double price);
}
