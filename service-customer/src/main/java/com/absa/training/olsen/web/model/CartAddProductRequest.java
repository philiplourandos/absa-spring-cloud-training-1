package com.absa.training.olsen.web.model;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

@Data
public class CartAddProductRequest {

    @NotBlank
    Long productId;
    @NotBlank
    Integer quantity;

}
