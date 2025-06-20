package com.testapi.demoapi.invoice.controller;

import com.testapi.demoapi.customer.dto.CustomerResponse;
import com.testapi.demoapi.invoice.dto.InvoiceRequest;
import com.testapi.demoapi.invoice.dto.InvoiceResponse;
import com.testapi.demoapi.invoice.service.InvoiceService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3009")
@RequestMapping("api/invoices")
public class InvoiceController {

    private final InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    // Create a invoice
    @PostMapping
    public ResponseEntity<Integer> createInvoice(@RequestBody @Valid InvoiceRequest invoiceRequest) {
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

    @GetMapping("/{customerId}/invoices")
    public Page<InvoiceResponse> getInvoicesByCustomer(
            @PathVariable Integer customerId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String direction
    ) {
        return invoiceService.getInvoicesByCustomer(customerId, page, size, sortBy, direction);
    }

    // get all invoices paginated
    @GetMapping("/paginated")
    public Page<InvoiceResponse> getCustomersPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return invoiceService.getInvoicesPaginated(page, size);
    }

    // get all invoices paginated and sorted
    @GetMapping("/sorted")
    public Page<InvoiceResponse> getCustomersPaginatedAndSorted(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String direction
    ) {
        return invoiceService.getInvoicesPaginatedAndSorted(page, size, sortBy, direction);
    }


    // ✅ Mettre à jour une facture
    @PutMapping("/{id}")
    public ResponseEntity<Integer> updateInvoice(@PathVariable Integer id, @RequestBody @Valid InvoiceRequest invoiceRequest) {
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
