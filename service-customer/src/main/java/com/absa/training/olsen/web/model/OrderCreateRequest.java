package com.absa.training.olsen.web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class OrderCreateRequest implements Serializable {

    @NotBlank
    String customerFirstName;
    @NotBlank
    String customerLastName;
    @NotBlank @Email
    String customerEmailAddress;

    List<Long> productIds = new ArrayList<>();

}
