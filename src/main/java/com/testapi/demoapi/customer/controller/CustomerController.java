package com.testapi.demoapi.customer.controller;

import com.testapi.demoapi.customer.dto.CustomerRequest;
import com.testapi.demoapi.customer.dto.CustomerResponse;
import com.testapi.demoapi.customer.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    // Create customer
    @PostMapping
    public ResponseEntity<Integer> createCustomer(@RequestBody CustomerRequest customerRequest) {
        Integer customerId = customerService.createCustomer(customerRequest);
        return new ResponseEntity<>(customerId, HttpStatus.CREATED);
    }

    // Search customer by id
    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> getCustomerById(@PathVariable Integer id) {
        CustomerResponse customer = customerService.getCustomerById(id);
        return ResponseEntity.ok(customer);
    }

    // keep all customers
    @GetMapping
    public ResponseEntity<List<CustomerResponse>> getAllCustomers() {
        List<CustomerResponse> customers = customerService.getAllCustomer();
        return ResponseEntity.ok(customers);
    }

    // Update a customer
    @PutMapping("/{id}")
    public ResponseEntity<Integer> updateCustomer(@PathVariable Integer id, @RequestBody CustomerRequest customerRequest) {
        Integer updatedId = customerService.updateCustomer(id, customerRequest);
        return ResponseEntity.ok(updatedId);
    }

    // Delete a customer
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Integer id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }
}
