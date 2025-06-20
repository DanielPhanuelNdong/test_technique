package com.testapi.demoapi.invoiceItems.service;

import com.testapi.demoapi.address.dto.AddressRequest;
import com.testapi.demoapi.address.dto.AddressResponse;
import com.testapi.demoapi.customer.CustomerEntity;
import com.testapi.demoapi.invoice.InvoiceEntity;
import com.testapi.demoapi.invoice.dto.InvoiceResponse;
import com.testapi.demoapi.invoiceItems.dto.InvoiceItemsRequest;
import com.testapi.demoapi.invoiceItems.dto.InvoiceItemsResponse;
import org.springframework.data.domain.Page;

import java.util.List;

public interface InvoiceItemsService {
    Integer createInvoiceItems(InvoiceItemsRequest invoiceItemsRequest);
    InvoiceItemsResponse getInvoiceItemsById(Integer id);
    List<InvoiceItemsResponse> getAllInvoiceItems();
    Page<InvoiceItemsResponse> getInvoicesInvoiceItemsPaginated(int page, int size);
    Page<InvoiceItemsResponse> getInvoicesItemsPaginatedAndSorted(int page, int size, String sortBy, String direction);
    Integer updateInvoiceItems(Integer id, InvoiceItemsRequest invoiceItemsRequest);
    void deleteInvoiceItems(Integer id);
}
