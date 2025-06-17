package com.testapi.demoapi.invoice.service;

import com.testapi.demoapi.customer.repository.RepositoryCustomer;
import com.testapi.demoapi.invoice.dto.InvoiceRequest;
import com.testapi.demoapi.invoice.dto.InvoiceResponse;
import com.testapi.demoapi.invoice.mappers.InvoiceMappers;
import com.testapi.demoapi.invoice.repository.RepositoryInvoice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceServiceImpl1 implements InvoiceService{
    private  final RepositoryInvoice repositoryInvoice;
    private final RepositoryCustomer repositoryCustomer;
    private final InvoiceMappers invoiceMappers;

    public InvoiceServiceImpl1(RepositoryInvoice repositoryInvoice, RepositoryCustomer repositoryCustomer, InvoiceMappers invoiceMappers) {
        this.repositoryInvoice = repositoryInvoice;
        this.repositoryCustomer = repositoryCustomer;
        this.invoiceMappers = invoiceMappers;
    }

    @Override
    public Integer createInvoice(InvoiceRequest invoiceRequest) {
        return 0;
    }

    @Override
    public InvoiceResponse getInvoiceById(Integer id) {
        return null;
    }

    @Override
    public List<InvoiceResponse> getAllInvoice() {
        return List.of();
    }

    @Override
    public Integer updateInvoice(Integer id, InvoiceRequest invoiceRequest) {
        return 0;
    }

    @Override
    public void deleteInvoice(Integer id) {

    }
}
