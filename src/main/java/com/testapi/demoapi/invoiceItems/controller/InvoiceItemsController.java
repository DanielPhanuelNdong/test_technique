package com.testapi.demoapi.invoiceItems.controller;

import com.testapi.demoapi.customer.dto.CustomerResponse;
import com.testapi.demoapi.invoice.InvoiceEntity;
import com.testapi.demoapi.invoiceItems.dto.InvoiceItemsRequest;
import com.testapi.demoapi.invoiceItems.dto.InvoiceItemsResponse;
import com.testapi.demoapi.invoiceItems.service.InvoiceItemsService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3009")
@RequestMapping("/api/invoices/items")
public class InvoiceItemsController {

    private final InvoiceItemsService invoiceItemsService;

    public InvoiceItemsController(InvoiceItemsService invoiceItemsService) {
        this.invoiceItemsService = invoiceItemsService;
    }


    // Create Invoice Items
    @PostMapping
    public ResponseEntity<Integer> createInvoiceItems(@RequestBody @Valid InvoiceItemsRequest invoiceItemsRequest) {
        Integer invoiceItemsId = invoiceItemsService.createInvoiceItems(invoiceItemsRequest);
        return new ResponseEntity<>(invoiceItemsId, HttpStatus.CREATED);
    }

    // Search Invoice Items by id
    @GetMapping("/{id}")
    public ResponseEntity<InvoiceItemsResponse> getInvoiceItemsById(@PathVariable Integer id) {
        InvoiceItemsResponse invoiceItemsResponse = invoiceItemsService.getInvoiceItemsById(id);
        return ResponseEntity.ok(invoiceItemsResponse);
    }

    // get all Invoice Items
    @GetMapping
    public ResponseEntity<List<InvoiceItemsResponse>> getAllInvoiceItems() {
        List<InvoiceItemsResponse> address = invoiceItemsService.getAllInvoiceItems();
        return ResponseEntity.ok(address);
    }

    // get all customers paginated
    @GetMapping("/paginated")
    public Page<InvoiceItemsResponse> getCustomersPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return invoiceItemsService.getInvoicesInvoiceItemsPaginated(page, size);
    }

    // get all customers paginated and sorted
    @GetMapping("/sorted")
    public Page<InvoiceItemsResponse> getCustomersPaginatedAndSorted(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String direction
    ) {
        return invoiceItemsService.getInvoicesItemsPaginatedAndSorted(page, size, sortBy, direction);
    }

    // Update an Invoice Items
    @PutMapping("/{id}")
    public ResponseEntity<Integer> updateInvoiceItems(@PathVariable Integer id, @RequestBody @Valid InvoiceItemsRequest invoiceItemsRequest) {
        Integer updatedId = invoiceItemsService.updateInvoiceItems(id, invoiceItemsRequest);
        return ResponseEntity.ok(updatedId);
    }

    // Delete an Invoice Items
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInvoiceItems(@PathVariable Integer id) {
        invoiceItemsService.deleteInvoiceItems(id);
        return ResponseEntity.noContent().build();
    }

}
