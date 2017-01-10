package com.absa.training.olsen.persistance.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.absa.training.olsen.persistance.enums.ProductStatus;
import com.absa.training.olsen.persistance.enums.ProductType;

import lombok.Data;

@Entity(name="product")
@Data
public class Product implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private long id;
	
	private String name;
	
	private String description;
	
	@Enumerated(EnumType.STRING)
	private ProductStatus productStatus;
	
	@Enumerated(EnumType.STRING)
	private ProductType productType;
	
	private int quanity;
}
