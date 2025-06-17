package com.testapi.demoapi.customer.repository;

import com.testapi.demoapi.customer.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RepositoryCustomer extends JpaRepository<CustomerEntity, Integer> {
    
}
