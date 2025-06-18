package com.testapi.demoapi.address.controller;

import com.testapi.demoapi.address.dto.AddressRequest;
import com.testapi.demoapi.address.dto.AddressResponse;
import com.testapi.demoapi.address.service.AddressService;
import com.testapi.demoapi.customer.CustomerEntity;
import com.testapi.demoapi.invoice.InvoiceEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    // Create Address
    @PostMapping
    public ResponseEntity<Integer> createAddress(@RequestBody AddressRequest addressRequest, InvoiceEntity invoiceEntity, CustomerEntity customerEntity) {
        Integer addressId = addressService.createAddress(addressRequest, invoiceEntity, customerEntity);
        return new ResponseEntity<>(addressId, HttpStatus.CREATED);
    }

    // Search Address by id
    @GetMapping("/{id}")
    public ResponseEntity<AddressResponse> getAddressById(@PathVariable Integer id) {
        AddressResponse address = addressService.getAddressById(id);
        return ResponseEntity.ok(address);
    }

    // get all address
    @GetMapping
    public ResponseEntity<List<AddressResponse>> getAllAddress() {
        List<AddressResponse> address = addressService.getAllAddress();
        return ResponseEntity.ok(address);
    }

    // Update an address
    @PutMapping("/{id}")
    public ResponseEntity<Integer> updateAddress(@PathVariable Integer id, @RequestBody AddressRequest addressRequest, InvoiceEntity invoiceEntity, CustomerEntity customerEntity) {
        Integer updatedId = addressService.updateAddress(id, addressRequest, invoiceEntity, customerEntity);
        return ResponseEntity.ok(updatedId);
    }

    // Delete an address
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable Integer id) {
        addressService.deleteAddress(id);
        return ResponseEntity.noContent().build();
    }

}
