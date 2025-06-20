package com.testapi.demoapi.invoiceItems.dto;

import com.testapi.demoapi.invoiceItems.InvoiceItemsEntity;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class InvoiceItemsRequest {

    @NotBlank(message = "The name is require")
    private String name;

    @NotNull(message = "The quantity is require")
    private Integer quantity;

    @NotNull(message = "The price is require")
    private Double price;

    @NotNull(message = "The total is require")
    private Double total;

    @NotNull(message = "The invoice is require")
    private Integer invoice;
}
