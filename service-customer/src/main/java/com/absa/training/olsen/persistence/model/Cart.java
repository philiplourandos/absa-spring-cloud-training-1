package com.absa.training.olsen.persistence.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Cart {

    @Id @GeneratedValue
    Long id;

    @OneToOne
    Customer customer;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    List<CartItem> items = new ArrayList<>();

    @Transient
    @JsonProperty(value = "itemCount")
    Integer getItemCount() {
        return this.items.size();
    }

}
