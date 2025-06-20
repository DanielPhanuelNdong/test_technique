package com.testapi.demoapi.invoice.service;

import com.testapi.demoapi.customer.dto.CustomerRequest;
import com.testapi.demoapi.customer.dto.CustomerResponse;
import com.testapi.demoapi.invoice.dto.InvoiceRequest;
import com.testapi.demoapi.invoice.dto.InvoiceResponse;
import org.springframework.data.domain.Page;

import java.util.List;

public interface InvoiceService {

    Integer createInvoice(InvoiceRequest invoiceRequest);
    InvoiceResponse getInvoiceById(Integer id);
    List<InvoiceResponse> getAllInvoice();
    Page<InvoiceResponse> getInvoicesPaginated(int page, int size);
    Page<InvoiceResponse> getInvoicesByCustomer(Integer customerId, int page, int size, String sortBy, String direction);
    Page<InvoiceResponse> getInvoicesPaginatedAndSorted(int page, int size, String sortBy, String direction);
    Integer updateInvoice(Integer id, InvoiceRequest invoiceRequest);
    void deleteInvoice(Integer id);
}
