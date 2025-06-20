package com.testapi.demoapi.customer.controller;

import com.testapi.demoapi.customer.dto.CustomerRequest;
import com.testapi.demoapi.customer.dto.CustomerResponse;
import com.testapi.demoapi.customer.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3009")
@RequestMapping("api/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    // Create customer
    @PostMapping
    public ResponseEntity<Integer> createCustomer(@RequestBody @Valid CustomerRequest customerRequest) {
        Integer customerId = customerService.createCustomer(customerRequest);
        return new ResponseEntity<>(customerId, HttpStatus.CREATED);
    }

    // Search customer by id
    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> getCustomerById(@PathVariable Integer id) {
        CustomerResponse customer = customerService.getCustomerById(id);
        return ResponseEntity.ok(customer);
    }

    // get all customers
    @GetMapping
    public ResponseEntity<List<CustomerResponse>> getAllCustomers() {
        List<CustomerResponse> customers = customerService.getAllCustomer();
        return ResponseEntity.ok(customers);
    }

    // get all customers paginated
    @GetMapping("/paginated")
    public Page<CustomerResponse> getCustomersPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return customerService.getCustomersPaginated(page, size);
    }

    // get all customers paginated and sorted
    @GetMapping("/sorted")
    public Page<CustomerResponse> getCustomersPaginatedAndSorted(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String direction
    ) {
        return customerService.getCustomersPaginatedAndSorted(page, size, sortBy, direction);
    }


    // Update a customer
    @PutMapping("/{id}")
    public ResponseEntity<Integer> updateCustomer(@PathVariable Integer id, @RequestBody @Valid CustomerRequest customerRequest) {
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
