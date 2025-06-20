package com.testapi.demoapi.invoice.repository;

import com.testapi.demoapi.customer.CustomerEntity;
import com.testapi.demoapi.invoice.InvoiceEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RepositoryInvoice extends JpaRepository<InvoiceEntity, Integer> {
    @EntityGraph(attributePaths = "invoiceItems")
    Optional<InvoiceEntity> findById(Integer id);

    Page<InvoiceEntity> findByCustomer(CustomerEntity customer, Pageable pageable);
}
