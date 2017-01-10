package com.absa.training.olsen.web.commands;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class CreateOrderCommand implements Serializable {

    String customerFirstName;
    String customerLastName;
    String customerEmailAddress;
    List<Long> productIds = new ArrayList<>();

}
