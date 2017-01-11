package com.absa.training.olsen.web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRegisterRequest implements Serializable {

    @NotBlank @Email
    String emailAddress;
    @NotBlank
    String firstName;
    @NotBlank
    String lastName;

}
