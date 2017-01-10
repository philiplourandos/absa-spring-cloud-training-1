package com.absa.training.olsen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.absa.training.olsen.persistance.enums.ProductStatus;
import com.absa.training.olsen.persistance.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

	List<Product> findProductsByProductStatus(ProductStatus productStatus);
	
}
