package com.testapi.demoapi.invoice.mappers;

import com.testapi.demoapi.customer.CustomerEntity;
import com.testapi.demoapi.invoice.InvoiceEntity;
import com.testapi.demoapi.invoice.dto.InvoiceRequest;
import com.testapi.demoapi.invoice.dto.InvoiceResponse;
import com.testapi.demoapi.invoiceItems.mappers.InvoiceItemsMappers;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InvoiceMappers {

    public static InvoiceResponse toDto(InvoiceEntity invoice) {
        InvoiceResponse invoiceResponse = new InvoiceResponse();
        invoiceResponse.setId(invoice.getId());
        invoiceResponse.setTotalAmount(invoice.getTotalAmount());
        invoiceResponse.setBillingAddress(invoice.getBillingAddress().getId());
        invoiceResponse.setInvoiceItems(invoice.getInvoiceItems().stream().map(invoiceItemsEntity -> InvoiceItemsMappers.toDto(invoiceItemsEntity, invoice)).toList());
        invoiceResponse.setCustomer(invoice.getCustomer().getId());

        return invoiceResponse;
    }

    public InvoiceEntity toEntity(InvoiceRequest invoiceRequest, CustomerEntity customer) {
        return InvoiceEntity.builder()
                .totalAmount(invoiceRequest.getTotalAmount())
                .customer(customer)
                .build();
    }


//    public InvoiceEntity toEntity(InvoiceRequest invoiceRequest) {
//        return InvoiceEntity.builder()
//                .totalAmount(invoiceRequest.getTotalAmount())
//                .customer(invoiceRequest.getCustomer())
//                .build();
//    }
}
