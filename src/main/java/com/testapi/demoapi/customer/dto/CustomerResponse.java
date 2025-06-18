package com.testapi.demoapi.customer.dto;

import com.testapi.demoapi.invoice.dto.InvoiceResponse;
import lombok.*;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CustomerResponse {
    private int id;
    private String name;
    private String email;
    private String phone;
    private  Integer address;
    private List<InvoiceResponse> invoices;

}
