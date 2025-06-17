package com.testapi.demoapi.invoice.dto;


import com.testapi.demoapi.customer.CustomerEntity;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class InvoiceResponse {
    private Integer id;
    private String totalAmount;
    private CustomerEntity customer;
}
