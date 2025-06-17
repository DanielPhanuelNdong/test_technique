package com.testapi.demoapi.customer.dto;

import lombok.*;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CustomerRequest {
    private String name;
    private String email;
    private String phone;
}
