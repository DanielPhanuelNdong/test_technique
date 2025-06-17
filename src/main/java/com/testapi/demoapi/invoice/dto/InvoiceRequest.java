package com.testapi.demoapi.invoice.dto;

import com.testapi.demoapi.customer.CustomerEntity;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class InvoiceRequest {
    private String totalAmount;
    private CustomerEntity customer;
}
