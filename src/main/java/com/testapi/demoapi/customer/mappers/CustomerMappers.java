package com.testapi.demoapi.customer.mappers;

import com.testapi.demoapi.customer.CustomerEntity;
import com.testapi.demoapi.customer.dto.CustomerRequest;
import com.testapi.demoapi.customer.dto.CustomerResponse;

public class CustomerMappers {

    public CustomerResponse toDto(CustomerEntity customer) {
        CustomerResponse customerResponse = new CustomerResponse();
        customerResponse.setId(customer.getId());
        customerResponse.setName(customer.getName());
        customerResponse.setEmail(customer.getEmail());
        customerResponse.setPhone(customer.getPhone());
        customerResponse.getInvoices(customer.);
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
