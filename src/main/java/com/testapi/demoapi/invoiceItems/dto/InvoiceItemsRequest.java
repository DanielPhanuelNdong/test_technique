package com.testapi.demoapi.invoiceItems.dto;

import com.testapi.demoapi.invoiceItems.InvoiceItemsEntity;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class InvoiceItemsRequest {

    private String name;
    private Integer quantity;
    private Double price;
    private Double total;
    private Integer invoice;
}
