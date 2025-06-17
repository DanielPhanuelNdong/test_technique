package com.testapi.demoapi.invoice.service;

import com.testapi.demoapi.customer.dto.CustomerRequest;
import com.testapi.demoapi.customer.dto.CustomerResponse;
import com.testapi.demoapi.invoice.dto.InvoiceRequest;
import com.testapi.demoapi.invoice.dto.InvoiceResponse;

import java.util.List;

public interface InvoiceService {

    Integer createInvoice(InvoiceRequest invoiceRequest);
    InvoiceResponse getInvoiceById(Integer id);
    List<InvoiceResponse> getAllInvoice();
    Integer updateInvoice(Integer id, InvoiceRequest invoiceRequest);
    void deleteInvoice(Integer id);
}
