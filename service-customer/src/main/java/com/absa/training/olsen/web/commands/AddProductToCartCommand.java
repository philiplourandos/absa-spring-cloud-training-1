package com.absa.training.olsen.web.commands;

import lombok.Data;

@Data
public class AddProductToCartCommand {

    Long productId;
    Integer quantity;

}
