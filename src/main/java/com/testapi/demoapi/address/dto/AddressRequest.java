package com.testapi.demoapi.address.dto;


import com.testapi.demoapi.customer.CustomerEntity;
import com.testapi.demoapi.invoice.InvoiceEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class AddressRequest {
    private String street;
    private String city;
    private String zipCode;
    private String country;
    private Integer customers;
    private Integer invoices;
}
