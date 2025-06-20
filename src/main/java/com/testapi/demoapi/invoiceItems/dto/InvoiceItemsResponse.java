package com.testapi.demoapi.invoiceItems.dto;


import com.testapi.demoapi.invoice.dto.InvoiceResponse;
import jakarta.persistence.Column;
import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class InvoiceItemsResponse {

    private Integer id;
    private String name;
    private Integer quantity;
    private Double price;
    private Double total;
    private Instant createAt;
    private Instant updateAt;
}
