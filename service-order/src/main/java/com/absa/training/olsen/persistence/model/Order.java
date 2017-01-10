package com.absa.training.olsen.persistence.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
public class Order {

    @Id @GeneratedValue
    Long id;
    LocalDateTime orderDateTime;
    String customerName;
    @Enumerated(EnumType.STRING)
    OrderStatus orderStatus;
    BigDecimal orderTotal;


}
