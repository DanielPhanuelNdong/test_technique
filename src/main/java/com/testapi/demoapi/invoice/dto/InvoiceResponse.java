package com.testapi.demoapi.invoice.dto;


import com.testapi.demoapi.address.dto.AddressResponse;
import com.testapi.demoapi.customer.CustomerEntity;
import com.testapi.demoapi.invoiceItems.dto.InvoiceItemsResponse;
import jakarta.persistence.Column;
import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class InvoiceResponse {
    private Integer id;
    private String totalAmount;
    private Instant createAt;
    private Instant updateAt;
    private Integer customer;
    private AddressResponse billingAddress;
    private List<InvoiceItemsResponse> invoiceItems;
}
