package com.testapi.demoapi.customer.service;

import com.testapi.demoapi.customer.dto.CustomerRequest;
import com.testapi.demoapi.customer.dto.CustomerResponse;

import java.util.List;

public interface CustomerService {
    Integer createCustomer(CustomerRequest customerRequest);
    CustomerResponse getCustomerById(Integer id);
    List<CustomerResponse> getAllCustomer();
    Integer updateUser(Integer id, CustomerRequest customerRequest);
    void deleteCustomer(Integer id);
}
