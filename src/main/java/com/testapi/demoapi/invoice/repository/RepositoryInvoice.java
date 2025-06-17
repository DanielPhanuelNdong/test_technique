package com.testapi.demoapi.invoice.repository;

import com.testapi.demoapi.invoice.InvoiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryInvoice extends JpaRepository<InvoiceEntity, Integer> {
}
