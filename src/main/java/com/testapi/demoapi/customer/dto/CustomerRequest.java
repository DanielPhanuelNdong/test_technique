package com.testapi.demoapi.customer.dto;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CustomerRequest {
    @NotBlank(message = "The name is require")
    private String name;

    @NotBlank(message = "The email is require")
    @Email(message = "Invalid email")
    private String email;

    @NotBlank(message = "The phone number is require")
    private String phone;

    private  Integer address;
}
