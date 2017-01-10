package com.absa.training.olsen.persistence.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
public class Order {

    Long id;
    LocalDateTime orderDateTime;
    String customerName;
    @Enumerated(EnumType.STRING)
    OrderStatus orderStatus;
    BigDecimal orderTotal;


}
