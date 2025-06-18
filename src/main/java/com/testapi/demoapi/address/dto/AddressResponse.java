package com.testapi.demoapi.address.dto;


import jakarta.persistence.Column;
import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class AddressResponse {
    private Integer id;
    private String street;
    private String city;
    private String zipCode;
    private String country;
    private Instant createAt;
    private Instant updateAt;
}
