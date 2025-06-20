package com.testapi.demoapi.customer.service;

import com.testapi.demoapi.customer.dto.CustomerRequest;
import com.testapi.demoapi.customer.dto.CustomerResponse;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CustomerService {
    Integer createCustomer(CustomerRequest customerRequest);
    CustomerResponse getCustomerById(Integer id);
    List<CustomerResponse> getAllCustomer();
    Page<CustomerResponse> getCustomersPaginated(int page, int size);
    Page<CustomerResponse> getCustomersPaginatedAndSorted(int page, int size, String sortBy, String direction);
    Integer updateCustomer(Integer id, CustomerRequest customerRequest);
    void deleteCustomer(Integer id);
}
