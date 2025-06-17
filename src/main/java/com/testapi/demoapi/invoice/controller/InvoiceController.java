package com.testapi.demoapi.invoice.controller;

import com.testapi.demoapi.invoice.dto.InvoiceRequest;
import com.testapi.demoapi.invoice.dto.InvoiceResponse;
import com.testapi.demoapi.invoice.service.InvoiceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/invoices")
public class InvoiceController {

    private final InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    // Create a invoice
    @PostMapping
    public ResponseEntity<Integer> createInvoice(@RequestBody InvoiceRequest invoiceRequest) {
        Integer invoiceId = invoiceService.createInvoice(invoiceRequest);
        return new ResponseEntity<>(invoiceId, HttpStatus.CREATED);
    }

    // Get invoice by ID
    @GetMapping("/{id}")
    public ResponseEntity<InvoiceResponse> getInvoiceById(@PathVariable Integer id) {
        InvoiceResponse invoice = invoiceService.getInvoiceById(id);
        return ResponseEntity.ok(invoice);
    }

    // ✅ Récupérer toutes les factures
    @GetMapping
    public ResponseEntity<List<InvoiceResponse>> getAllInvoices() {
        List<InvoiceResponse> invoices = invoiceService.getAllInvoice();
        return ResponseEntity.ok(invoices);
    }

    // ✅ Mettre à jour une facture
    @PutMapping("/{id}")
    public ResponseEntity<Integer> updateInvoice(@PathVariable Integer id, @RequestBody InvoiceRequest invoiceRequest) {
        Integer updatedId = invoiceService.updateInvoice(id, invoiceRequest);
        return ResponseEntity.ok(updatedId);
    }

    // ✅ Supprimer une facture
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInvoice(@PathVariable Integer id) {
        invoiceService.deleteInvoice(id);
        return ResponseEntity.noContent().build();
    }

}
