package com.absa.training.olsen.persistence.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
public class Customer implements Serializable {

    @Id @GeneratedValue
    Long id;
    String emailAddress;
    String firstName;
    String lastName;

}
