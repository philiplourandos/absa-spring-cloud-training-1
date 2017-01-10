package com.absa.training.olsen.web.commands;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterCustomerCommand implements Serializable {

    String emailAddress;
    String firstName;
    String lastName;

}
