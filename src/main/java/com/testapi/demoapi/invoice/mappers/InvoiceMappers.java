package com.testapi.demoapi.invoice.mappers;

import com.testapi.demoapi.address.AddressEntity;
import com.testapi.demoapi.address.dto.AddressResponse;
import com.testapi.demoapi.address.mappers.AddressMappers;
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
        invoiceResponse.setCreateAt(invoice.getCreateAt());
        invoiceResponse.setUpdateAt(invoice.getUpdateAt());
        invoiceResponse.setInvoiceItems(invoice.getInvoiceItems().stream().map(InvoiceItemsMappers::toDto).toList());
        invoiceResponse.setCustomer(invoice.getCustomer().getId());

        if (invoice.getBillingAddress() != null) {
            AddressResponse addressResponses = AddressMappers.toDto(invoice.getBillingAddress());
            invoiceResponse.setBillingAddress(addressResponses);
        } else {
            invoiceResponse.setBillingAddress(null);
        }

        return invoiceResponse;
    }

    public InvoiceEntity toEntity(InvoiceRequest invoiceRequest, CustomerEntity customer, AddressEntity billingAddress) {
        return InvoiceEntity.builder()
                .totalAmount(invoiceRequest.getTotalAmount())
                .customer(customer)
                .billingAddress(billingAddress)
                .build();
    }


//    public InvoiceEntity toEntity(InvoiceRequest invoiceRequest) {
//        return InvoiceEntity.builder()
//                .totalAmount(invoiceRequest.getTotalAmount())
//                .customer(invoiceRequest.getCustomer())
//                .build();
//    }
}
