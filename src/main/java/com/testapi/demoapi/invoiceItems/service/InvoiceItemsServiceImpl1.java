package com.testapi.demoapi.invoiceItems.service;

import com.testapi.demoapi.address.AddressEntity;
import com.testapi.demoapi.exceptions.ElementNotFoundException;
import com.testapi.demoapi.invoice.InvoiceEntity;
import com.testapi.demoapi.invoice.mappers.InvoiceMappers;
import com.testapi.demoapi.invoice.repository.RepositoryInvoice;
import com.testapi.demoapi.invoiceItems.InvoiceItemsEntity;
import com.testapi.demoapi.invoiceItems.dto.InvoiceItemsRequest;
import com.testapi.demoapi.invoiceItems.dto.InvoiceItemsResponse;
import com.testapi.demoapi.invoiceItems.mappers.InvoiceItemsMappers;
import com.testapi.demoapi.invoiceItems.repository.InvoiceItemsRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
    public Integer createInvoiceItems(InvoiceItemsRequest invoiceItemsRequest) {
        InvoiceEntity invoiceEntity = repositoryInvoice.findById(invoiceItemsRequest.getInvoice())
                .orElseThrow(() -> new ElementNotFoundException("invoice with ID " + invoiceItemsRequest.getInvoice()+ " not found"));
        InvoiceItemsEntity invoiceItems = invoiceItemsMappers.toEntity(invoiceItemsRequest, invoiceEntity);
        invoiceItems = invoiceItemsRepository.save(invoiceItems);
        return invoiceItems.getId();
    }

    @Override
    public InvoiceItemsResponse getInvoiceItemsById(Integer id) {
        InvoiceItemsEntity invoiceItems = invoiceItemsRepository.findById(id)
                .orElseThrow(() -> new ElementNotFoundException("invoice items with ID " + id + " not found"));
        return InvoiceItemsMappers.toDto(invoiceItems);
    }

    @Override
    public List<InvoiceItemsResponse> getAllInvoiceItems() {
        return invoiceItemsRepository.findAll()
                .stream()
                .map(InvoiceItemsMappers::toDto)
                .toList();
    }

    @Override
    public Page<InvoiceItemsResponse> getInvoicesInvoiceItemsPaginated(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return invoiceItemsRepository.findAll(pageable)
                .map(InvoiceItemsMappers::toDto);
    }

    @Override
    public Page<InvoiceItemsResponse> getInvoicesItemsPaginatedAndSorted(int page, int size, String sortBy, String direction) {
        Sort sort = direction.equalsIgnoreCase("desc") ?
                Sort.by(sortBy).descending() :
                Sort.by(sortBy).ascending();

        Pageable pageable = PageRequest.of(page, size, sort);
        return invoiceItemsRepository.findAll(pageable)
                .map(InvoiceItemsMappers::toDto);
    }

    @Override
    public Integer updateInvoiceItems(Integer id, InvoiceItemsRequest invoiceItemsRequest) {
        InvoiceItemsEntity existingItems = invoiceItemsRepository.findById(id)
                .orElseThrow(() -> new ElementNotFoundException("invoice items with ID " + id + " not found"));

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
                .orElseThrow(() -> new ElementNotFoundException("Invoice items with ID " + id + " not found"));
        invoiceItemsRepository.delete(invoiceItems);
    }
}
