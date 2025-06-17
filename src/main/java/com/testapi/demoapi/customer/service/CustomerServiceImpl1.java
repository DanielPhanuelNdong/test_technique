package com.testapi.demoapi.customer.service;

import com.testapi.demoapi.customer.dto.CustomerRequest;
import com.testapi.demoapi.customer.dto.CustomerResponse;

import java.util.List;

public class CustomerServiceImpl1 implements  CustomerService{
    @Override
    public Integer createCustomer(CustomerRequest customerRequest) {
        return 0;
    }

    @Override
    public CustomerResponse getCustomerById(Integer id) {
        return null;
    }

    @Override
    public List<CustomerResponse> getAllCustomer() {
        return List.of();
    }

    @Override
    public Integer updateUser(Integer id, CustomerRequest customerRequest) {
        return 0;
    }

    @Override
    public void deleteCustomer(Integer id) {

    }
}
