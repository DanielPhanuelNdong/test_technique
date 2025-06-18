package com.testapi.demoapi.invoiceItems.service;

import com.testapi.demoapi.address.AddressEntity;
import com.testapi.demoapi.invoice.InvoiceEntity;
import com.testapi.demoapi.invoice.repository.RepositoryInvoice;
import com.testapi.demoapi.invoiceItems.InvoiceItemsEntity;
import com.testapi.demoapi.invoiceItems.dto.InvoiceItemsRequest;
import com.testapi.demoapi.invoiceItems.dto.InvoiceItemsResponse;
import com.testapi.demoapi.invoiceItems.mappers.InvoiceItemsMappers;
import com.testapi.demoapi.invoiceItems.repository.InvoiceItemsRepository;

import java.util.List;

public class InvoiceItemsServiceImpl1 implements InvoiceItemsService{

    private final InvoiceItemsRepository invoiceItemsRepository;
    private final InvoiceItemsMappers invoiceItemsMappers;
    private final RepositoryInvoice repositoryInvoice;

    public InvoiceItemsServiceImpl1(InvoiceItemsRepository invoiceItemsRepository, InvoiceItemsMappers invoiceItemsMappers, RepositoryInvoice repositoryInvoice) {
        this.invoiceItemsRepository = invoiceItemsRepository;
        this.invoiceItemsMappers = invoiceItemsMappers;
        this.repositoryInvoice = repositoryInvoice;
    }

    @Override
    public Integer createInvoiceItems(InvoiceItemsRequest invoiceItemsRequest, InvoiceEntity invoiceEntity) {
        InvoiceItemsEntity invoiceItems = invoiceItemsMappers.toEntity(invoiceItemsRequest, invoiceEntity);
        invoiceItems = invoiceItemsRepository.save(invoiceItems);
        return invoiceItems.getId();
    }

    @Override
    public InvoiceItemsResponse getInvoiceItemsById(Integer id) {
        InvoiceItemsEntity invoiceItems = invoiceItemsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("invoice items with ID " + id + " not found"));
        InvoiceEntity invoiceEntity = repositoryInvoice.findById(invoiceItems.getInvoice().getId())
                .orElseThrow(() -> new RuntimeException("invoice with ID " + invoiceItems.getInvoice().getId() + " not found"));
        return InvoiceItemsMappers.toDto(invoiceItems, invoiceEntity);
    }

    @Override
    public List<InvoiceItemsResponse> getAllInvoiceItems() {
        return invoiceItemsRepository.findAll()
                .stream()
                .map(invoiceItemsEntity -> InvoiceItemsMappers.toDto(invoiceItemsEntity, invoiceItemsEntity.getInvoice()))
                .toList();
    }

    @Override
    public Integer updateInvoiceItems(Integer id, InvoiceItemsRequest invoiceItemsRequest) {
        InvoiceItemsEntity existingItems = invoiceItemsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("invoice items with ID " + id + " not found"));

        existingItems.setName(invoiceItemsRequest.getName());
        existingItems.setPrice(invoiceItemsRequest.getPrice());
        existingItems.setQuantity(invoiceItemsRequest.getQuantity());
        existingItems.setTotal(invoiceItemsRequest.getTotal());
        existingItems.setInvoice(existingItems.getInvoice());

        existingItems = invoiceItemsRepository.save(existingItems);
        return existingItems.getId();
    }

    @Override
    public void deleteInvoiceItems(Integer id) {
        InvoiceItemsEntity invoiceItems = invoiceItemsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Invoice items with ID " + id + " not found"));
        invoiceItemsRepository.delete(invoiceItems);
    }
}
