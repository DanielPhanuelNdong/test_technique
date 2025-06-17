package com.testapi.demoapi.customer.mappers;

import com.testapi.demoapi.customer.CustomerEntity;
import com.testapi.demoapi.customer.dto.CustomerRequest;
import com.testapi.demoapi.customer.dto.CustomerResponse;
import com.testapi.demoapi.invoice.dto.InvoiceResponse;
import com.testapi.demoapi.invoice.mappers.InvoiceMappers;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerMappers {

    public CustomerResponse toDto(CustomerEntity customer) {
        CustomerResponse customerResponse = new CustomerResponse();
        customerResponse.setId(customer.getId());
        customerResponse.setName(customer.getName());
        customerResponse.setEmail(customer.getEmail());
        customerResponse.setPhone(customer.getPhone());
        List<InvoiceResponse> invoiceResponses = customer.getInvoices().stream().map(InvoiceMappers::toDto).toList();
        customerResponse.setInvoices(invoiceResponses);
        return customerResponse;
    }

    public CustomerEntity toEntity(CustomerRequest customerRequest) {
        return CustomerEntity.builder()
                .name(customerRequest.getName())
                .email(customerRequest.getEmail())
                .phone(customerRequest.getPhone())
                .build();
    }

}
