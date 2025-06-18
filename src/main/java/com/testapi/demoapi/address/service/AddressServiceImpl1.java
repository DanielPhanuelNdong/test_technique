package com.testapi.demoapi.address.service;

import com.testapi.demoapi.address.AddressEntity;
import com.testapi.demoapi.address.dto.AddressRequest;
import com.testapi.demoapi.address.dto.AddressResponse;
import com.testapi.demoapi.address.mappers.AddressMappers;
import com.testapi.demoapi.address.repository.AddressRepository;
import com.testapi.demoapi.customer.CustomerEntity;
import com.testapi.demoapi.customer.repository.RepositoryCustomer;
import com.testapi.demoapi.invoice.InvoiceEntity;
import com.testapi.demoapi.invoice.repository.RepositoryInvoice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl1 implements AddressService{


    private final AddressRepository addressRepository;
    private final AddressMappers addressMappers;
    private final RepositoryCustomer repositoryCustomer;
    private final RepositoryInvoice repositoryInvoice;

    public AddressServiceImpl1(AddressRepository addressRepository, AddressMappers addressMappers, RepositoryCustomer repositoryCustomer, RepositoryInvoice repositoryInvoice) {
        this.addressRepository = addressRepository;
        this.addressMappers = addressMappers;
        this.repositoryCustomer = repositoryCustomer;
        this.repositoryInvoice = repositoryInvoice;
    }

    @Override
    public Integer createAddress(AddressRequest addressRequest) {
        InvoiceEntity invoiceEntity = repositoryInvoice.findById(addressRequest.getInvoices())
                .orElseThrow(() -> new RuntimeException("Invoice with ID " + addressRequest.getInvoices() + " not found"));
        CustomerEntity customerEntity = repositoryCustomer.findById(addressRequest.getCustomers())
                .orElseThrow(() -> new RuntimeException("Customer with ID " + addressRequest.getInvoices() + " not found"));
        AddressEntity address = addressMappers.toEntity(addressRequest, invoiceEntity, customerEntity);
        address = addressRepository.save(address);
        return address.getId();
    }

    @Override
    public AddressResponse getAddressById(Integer id) {
        AddressEntity address = addressRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Address with ID " + id + " not found"));
        return AddressMappers.toDto(address);
    }

    @Override
    public List<AddressResponse> getAllAddress() {
        return addressRepository.findAll()
                .stream()
                .map(AddressMappers::toDto)
                .toList();
    }

    @Override
    public Integer updateAddress(Integer id, AddressRequest addressRequest) {
        InvoiceEntity invoiceEntity = repositoryInvoice.findById(addressRequest.getInvoices())
                .orElseThrow(() -> new RuntimeException("Invoice with ID " + addressRequest.getInvoices() + " not found"));
        CustomerEntity customerEntity = repositoryCustomer.findById(addressRequest.getCustomers())
                .orElseThrow(() -> new RuntimeException("Customer with ID " + addressRequest.getInvoices() + " not found"));
        AddressEntity existingAddress = addressRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Address with ID " + id + " not found"));

        existingAddress.setCity(addressRequest.getCity());
        existingAddress.setCountry(addressRequest.getCountry());
        existingAddress.setStreet(addressRequest.getStreet());
        existingAddress.setZipCode(addressRequest.getZipCode());
        existingAddress.setInvoices(List.of(invoiceEntity));
        existingAddress.setCustomers(List.of(customerEntity));

        existingAddress = addressRepository.save(existingAddress);
        return existingAddress.getId();
    }

    @Override
    public void deleteAddress(Integer id) {
        AddressEntity address = addressRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Address with ID " + id + " not found"));
        addressRepository.delete(address);
    }
}
