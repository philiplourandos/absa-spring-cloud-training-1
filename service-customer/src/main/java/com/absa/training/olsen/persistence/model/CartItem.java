package com.absa.training.olsen.persistence.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class CartItem implements Serializable {

    @Id @GeneratedValue
    Long id;
    Long productId;
    Integer quantity;

    @JsonIgnore
    @ManyToOne
    Cart parent;
}
