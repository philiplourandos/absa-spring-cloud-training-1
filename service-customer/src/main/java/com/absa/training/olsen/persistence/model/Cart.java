package com.absa.training.olsen.persistence.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Cart {

    @Id @GeneratedValue
    Long id;

    @OneToOne
    Customer customer;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    List<CartItem> items;

}
