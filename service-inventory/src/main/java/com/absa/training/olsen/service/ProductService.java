package com.absa.training.olsen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.absa.training.olsen.persistance.enums.ProductStatus;
import com.absa.training.olsen.persistance.model.Product;
import com.absa.training.olsen.repository.ProductRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductService {

	private ProductRepository productRepository;
	
	@Autowired
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	public List<Product> findAllProductsByStatus(ProductStatus status) {
		
		log.info("returning  list of products by " + status);
		return productRepository.findProductsByProductStatus(status);
	}
	
	public Product findProductById(Long id) {
		return productRepository.findOne(id);
	}
	
	public void addProduct(Product product) {
		this.productRepository.save(product);
	}
	
	public void deleteProduct(Product product) {
		this.productRepository.delete(product);
	}
	
	
	
	
}
