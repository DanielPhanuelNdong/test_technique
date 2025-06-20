package com.testapi.demoapi.address.service;

import com.testapi.demoapi.address.dto.AddressRequest;
import com.testapi.demoapi.address.dto.AddressResponse;
import com.testapi.demoapi.customer.CustomerEntity;
import com.testapi.demoapi.customer.dto.CustomerResponse;
import com.testapi.demoapi.invoice.InvoiceEntity;
import org.springframework.data.domain.Page;

import java.util.List;

public interface AddressService {
    Integer createAddress(AddressRequest addressRequest);
    AddressResponse getAddressById(Integer id);
    List<AddressResponse> getAllAddress();
    Page<AddressResponse> getAddressPaginated(int page, int size);
    Page<AddressResponse> getAddressPaginatedAndSorted(int page, int size, String sortBy, String direction);
    Integer updateAddress(Integer id, AddressRequest addressRequest);
    void deleteAddress(Integer id);
}
