package com.testapi.demoapi.invoice.dto;


import com.testapi.demoapi.address.dto.AddressResponse;
import com.testapi.demoapi.customer.CustomerEntity;
import com.testapi.demoapi.invoiceItems.dto.InvoiceItemsResponse;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class InvoiceResponse {
    private Integer id;
    private String totalAmount;
    private AddressResponse billingAddress;
    private Integer customer;
    private List<InvoiceItemsResponse> invoiceItems;
}
