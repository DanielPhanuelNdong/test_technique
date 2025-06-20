package com.testapi.demoapi.address.dto;


import com.testapi.demoapi.customer.CustomerEntity;
import com.testapi.demoapi.invoice.InvoiceEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class AddressRequest {

    @NotBlank(message = "The street is require")
    private String street;

    @NotBlank(message = "The city is require")
    private String city;

    @NotBlank(message = "The zipCode is require")
    private String zipCode;

    @NotBlank(message = "The country is require")
    private String country;
//
//    @NotBlank(message = "The customer is require")
//    private Integer customers;
//
//    @NotBlank(message = "The invoice is require")
//    private Integer invoices;
}
