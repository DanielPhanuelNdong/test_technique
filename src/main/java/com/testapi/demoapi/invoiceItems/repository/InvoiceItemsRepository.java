package com.testapi.demoapi.invoiceItems.repository;

import com.testapi.demoapi.invoiceItems.InvoiceItemsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceItemsRepository extends JpaRepository<InvoiceItemsEntity, Integer> {
}
