package com.testapi.demoapi.customer.mappers;

import com.testapi.demoapi.address.dto.AddressResponse;
import com.testapi.demoapi.address.mappers.AddressMappers;
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
        customerResponse.setCreateAt(customer.getCreateAt());
        customerResponse.setUpdateAt(customer.getUpdateAt());

        if (customer.getAddress() != null) {
            AddressResponse addressResponses = AddressMappers.toDto(customer.getAddress());
            customerResponse.setAddress(addressResponses);
        } else {
            customerResponse.setAddress(null);
        }

        if (customer.getInvoices() != null) {
            List<InvoiceResponse> invoiceResponses = customer.getInvoices().stream()
                    .map(InvoiceMappers::toDto)
                    .toList();
            customerResponse.setInvoices(invoiceResponses);
        } else {
            customerResponse.setInvoices(List.of());
        }

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
