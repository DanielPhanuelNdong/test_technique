package com.testapi.demoapi.customer.service;

import com.testapi.demoapi.address.AddressEntity;
import com.testapi.demoapi.address.repository.AddressRepository;
import com.testapi.demoapi.customer.CustomerEntity;
import com.testapi.demoapi.customer.dto.CustomerRequest;
import com.testapi.demoapi.customer.dto.CustomerResponse;
import com.testapi.demoapi.customer.mappers.CustomerMappers;
import com.testapi.demoapi.customer.repository.RepositoryCustomer;
import com.testapi.demoapi.exceptions.ElementNotFoundException;
import com.testapi.demoapi.invoice.repository.RepositoryInvoice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl1 implements  CustomerService{

    private final RepositoryCustomer repositoryCustomer;
    private final CustomerMappers customerMappers;
    private final AddressRepository addressRepository;

    public CustomerServiceImpl1(RepositoryInvoice repositoryInvoice, RepositoryCustomer repositoryCustomer, CustomerMappers customerMappers, AddressRepository addressRepository) {
        this.repositoryCustomer = repositoryCustomer;
        this.customerMappers = customerMappers;
        this.addressRepository = addressRepository;
    }


    @Override
    public Integer createCustomer(CustomerRequest customerRequest) {
        AddressEntity address = new AddressEntity();
        // Verify that address exist
        if(customerRequest.getAddress() != null){
            address = addressRepository.findById(customerRequest.getAddress())
                    .orElseThrow(() -> new ElementNotFoundException("address with ID " + customerRequest.getAddress() + " not found"));
        }else {
            address = null;
        }

        CustomerEntity customer = customerMappers.toEntity(customerRequest, address);
        customer = repositoryCustomer.save(customer);
        return customer.getId();
    }

    @Override
    public CustomerResponse getCustomerById(Integer id) {
        CustomerEntity customer = repositoryCustomer.findWithInvoicesById(id)
                .orElseThrow(() -> new ElementNotFoundException("Customer with ID " + id + " not found"));
        return customerMappers.toDto(customer);
    }

    @Override
    public List<CustomerResponse> getAllCustomer() {
        return repositoryCustomer.findAll()
                .stream()
                .map(customerMappers::toDto)
                .toList();
    }

    @Override
    public Page<CustomerResponse> getCustomersPaginated(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return repositoryCustomer.findAll(pageable)
                .map(customerMappers::toDto);
    }

    @Override
    public Page<CustomerResponse> getCustomersPaginatedAndSorted(int page, int size, String sortBy, String direction) {
        Sort sort = direction.equalsIgnoreCase("desc") ?
                Sort.by(sortBy).descending() :
                Sort.by(sortBy).ascending();

        Pageable pageable = PageRequest.of(page, size, sort);
        return repositoryCustomer.findAll(pageable)
                .map(customerMappers::toDto);
    }

    @Override
    public Integer updateCustomer(Integer id, CustomerRequest customerRequest) {
        CustomerEntity existingCustomer = repositoryCustomer.findWithInvoicesById(id)
                .orElseThrow(() -> new ElementNotFoundException("Customer with ID " + id + " not found"));

        existingCustomer.setName(customerRequest.getName());
        existingCustomer.setEmail(customerRequest.getEmail());
        existingCustomer.setPhone(customerRequest.getPhone());

        existingCustomer = repositoryCustomer.save(existingCustomer);
        return existingCustomer.getId();
    }

    @Override
    public void deleteCustomer(Integer id) {
        CustomerEntity customer = repositoryCustomer.findById(id)
                .orElseThrow(() -> new ElementNotFoundException("Customer with ID " + id + " not found"));
        repositoryCustomer.delete(customer);
    }
}
