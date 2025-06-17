package com.testapi.demoapi.customer.repository;

import com.testapi.demoapi.customer.CustomerEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface RepositoryCustomer extends JpaRepository<CustomerEntity, Integer> {

    @EntityGraph(attributePaths = "invoices")
    Optional<CustomerEntity> findWithInvoicesById(Integer id);
}
