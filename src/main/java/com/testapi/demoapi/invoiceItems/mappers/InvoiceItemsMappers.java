package com.testapi.demoapi.invoiceItems.mappers;

import com.testapi.demoapi.invoice.InvoiceEntity;
import com.testapi.demoapi.invoice.mappers.InvoiceMappers;
import com.testapi.demoapi.invoiceItems.InvoiceItemsEntity;
import com.testapi.demoapi.invoiceItems.dto.InvoiceItemsRequest;
import com.testapi.demoapi.invoiceItems.dto.InvoiceItemsResponse;
import org.springframework.stereotype.Component;

@Component
public class InvoiceItemsMappers {


    public static InvoiceItemsResponse toDto(InvoiceItemsEntity invoiceItemsEntity) {
        return InvoiceItemsResponse.builder()
                .id(invoiceItemsEntity.getId())
                .name(invoiceItemsEntity.getName())
                .price(invoiceItemsEntity.getPrice())
                .total(invoiceItemsEntity.getTotal())
                .quantity(invoiceItemsEntity.getQuantity())
                .createAt(invoiceItemsEntity.getCreateAt())
                .updateAt(invoiceItemsEntity.getUpdateAt())
                .build();
    }

    public InvoiceItemsEntity toEntity(InvoiceItemsRequest invoiceItemsRequest, InvoiceEntity invoiceEntity) {
        return InvoiceItemsEntity.builder()
                .name(invoiceItemsRequest.getName())
                .price(invoiceItemsRequest.getPrice())
                .quantity(invoiceItemsRequest.getQuantity())
                .total(invoiceItemsRequest.getPrice())
                .invoice(invoiceEntity)
                .build();
    }
}
