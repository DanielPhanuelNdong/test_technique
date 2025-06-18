package com.testapi.demoapi.address.service;

import com.testapi.demoapi.address.AddressEntity;
import com.testapi.demoapi.address.dto.AddressRequest;
import com.testapi.demoapi.address.dto.AddressResponse;
import com.testapi.demoapi.address.mappers.AddressMappers;
import com.testapi.demoapi.address.repository.AddressRepository;
import com.testapi.demoapi.customer.CustomerEntity;
import com.testapi.demoapi.invoice.InvoiceEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl1 implements AddressService{


    private final AddressRepository addressRepository;
    private final AddressMappers addressMappers;

    public AddressServiceImpl1(AddressRepository addressRepository, AddressMappers addressMappers) {
        this.addressRepository = addressRepository;
        this.addressMappers = addressMappers;
    }

    @Override
    public Integer createAddress(AddressRequest addressRequest, InvoiceEntity invoiceEntity, CustomerEntity customerEntity) {
        AddressEntity address = addressMappers.toEntity(addressRequest, invoiceEntity, customerEntity);
        address = addressRepository.save(address);
        return address.getId();
    }

    @Override
    public AddressResponse getAddressById(Integer id) {
        AddressEntity address = addressRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Address with ID " + id + " not found"));
        return addressMappers.toDto(address);
    }

    @Override
    public List<AddressResponse> getAllAddress() {
        return addressRepository.findAll()
                .stream()
                .map(addressMappers::toDto)
                .toList();
    }

    @Override
    public Integer updateAddress(Integer id, AddressRequest addressRequest, InvoiceEntity invoiceEntity, CustomerEntity customerEntity) {
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
