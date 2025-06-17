package com.testapi.demoapi.invoice.service;

import com.testapi.demoapi.customer.CustomerEntity;
import com.testapi.demoapi.customer.repository.RepositoryCustomer;
import com.testapi.demoapi.invoice.InvoiceEntity;
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
        // Verify that customer exist
        CustomerEntity customer = repositoryCustomer.findById(invoiceRequest.getCustomer())
                .orElseThrow(() -> new RuntimeException("Customer with ID " + invoiceRequest.getCustomer() + " not found"));

        // To mapp request in entity
        InvoiceEntity invoice = invoiceMappers.toEntity(invoiceRequest, customer);
        invoice.setCustomer(customer);

        // Save
        invoice = repositoryInvoice.save(invoice);
        return invoice.getId();
    }

    @Override
    public InvoiceResponse getInvoiceById(Integer id) {
        InvoiceEntity invoice = repositoryInvoice.findById(id)
                .orElseThrow(() -> new RuntimeException("Invoice with ID " + id + " not found"));
        return InvoiceMappers.toDto(invoice);
    }

    @Override
    public List<InvoiceResponse> getAllInvoice() {
        return repositoryInvoice.findAll()
                .stream()
                .map(InvoiceMappers::toDto)
                .toList();
    }

    @Override
    public Integer updateInvoice(Integer id, InvoiceRequest invoiceRequest) {
        InvoiceEntity existingInvoice = repositoryInvoice.findById(id)
                .orElseThrow(() -> new RuntimeException("Invoice with ID " + id + " not found"));

        CustomerEntity customer = repositoryCustomer.findById(invoiceRequest.getCustomer())
                .orElseThrow(() -> new RuntimeException("Customer with ID " + invoiceRequest.getCustomer() + " not found"));

        existingInvoice.setTotalAmount(invoiceRequest.getTotalAmount());
        existingInvoice.setCustomer(customer);

        existingInvoice = repositoryInvoice.save(existingInvoice);
        return existingInvoice.getId();
    }

    @Override
    public void deleteInvoice(Integer id) {
        InvoiceEntity invoice = repositoryInvoice.findById(id)
                .orElseThrow(() -> new RuntimeException("Invoice with ID " + id + " not found"));
        repositoryInvoice.delete(invoice);
    }
}
