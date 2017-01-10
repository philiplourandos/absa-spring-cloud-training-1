package com.absa.training.olsen.web.commands;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CreateOrderCommand {

    String customerFirstName;
    String customerLastName;
    String customerEmailAddress;
    List<Long> productIds = new ArrayList<>();
}
