package com.absa.training.olsen.web.rest;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.absa.training.olsen.persistance.enums.ProductStatus;
import com.absa.training.olsen.persistance.model.Product;
import com.absa.training.olsen.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	private ProductService productService;
	
	@Autowired
	public ProductController (ProductService productService) {
		this.productService = productService;
	}
	
	@RequestMapping(value="list/{status}", method = RequestMethod.GET)
	public List<Product> findAllProductsByStatus(@PathVariable("status") ProductStatus status) {
		return this.productService.findAllProductsByStatus(status) ;
	}
	
}
