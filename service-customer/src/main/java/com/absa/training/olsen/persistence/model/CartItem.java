package com.absa.training.olsen.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
public class CartItem {

    @Id @GeneratedValue
    Long id;
    Long productId;
    Integer quantity;

    @ManyToOne
    Cart parent;
}
