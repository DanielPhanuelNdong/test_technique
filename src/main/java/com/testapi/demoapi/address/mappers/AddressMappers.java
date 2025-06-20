package com.testapi.demoapi.address.mappers;

import com.testapi.demoapi.address.AddressEntity;
import com.testapi.demoapi.address.dto.AddressRequest;
import com.testapi.demoapi.address.dto.AddressResponse;
import com.testapi.demoapi.customer.CustomerEntity;
import com.testapi.demoapi.invoice.InvoiceEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AddressMappers {

    public static AddressResponse toDto(AddressEntity addressEntity) {
        return AddressResponse.builder()
                .id(addressEntity.getId())
                .street(addressEntity.getStreet())
                .city(addressEntity.getCity())
                .country(addressEntity.getCountry())
                .zipCode(addressEntity.getZipCode())
                .createAt(addressEntity.getCreateAt())
                .updateAt(addressEntity.getUpdateAt())
                .build();
    }

    public AddressEntity toEntity(AddressRequest addressRequest) {
        return AddressEntity.builder()
                .city(addressRequest.getCity())
                .country(addressRequest.getCountry())
                .street(addressRequest.getStreet())
                .zipCode(addressRequest.getZipCode())
                .build();
    }
}
