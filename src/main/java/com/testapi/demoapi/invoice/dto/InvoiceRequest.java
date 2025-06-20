package com.testapi.demoapi.invoice.dto;

import com.testapi.demoapi.customer.CustomerEntity;
import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class InvoiceRequest {

    @NotBlank(message = "The total amount is require")
    private String totalAmount;

    @NotNull(message = "The customer is require")
    private Integer customer;

    private Integer billingAddress;
}
