package com.testapi.demoapi.invoiceItems.service;

import com.testapi.demoapi.address.dto.AddressRequest;
import com.testapi.demoapi.address.dto.AddressResponse;
import com.testapi.demoapi.customer.CustomerEntity;
import com.testapi.demoapi.invoice.InvoiceEntity;
import com.testapi.demoapi.invoiceItems.dto.InvoiceItemsRequest;
import com.testapi.demoapi.invoiceItems.dto.InvoiceItemsResponse;

import java.util.List;

public interface InvoiceItemsService {
    Integer createInvoiceItems(InvoiceItemsRequest invoiceItemsRequest, InvoiceEntity invoiceEntity);
    InvoiceItemsResponse getInvoiceItemsById(Integer id);
    List<InvoiceItemsResponse> getAllInvoiceItems();
    Integer updateInvoiceItems(Integer id, InvoiceItemsRequest invoiceItemsRequest);
    void deleteInvoiceItems(Integer id);
}
