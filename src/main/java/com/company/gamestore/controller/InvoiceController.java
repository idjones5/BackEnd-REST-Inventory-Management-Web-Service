package com.company.gamestore.controller;

import com.company.gamestore.models.Invoice;
import com.company.gamestore.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class InvoiceController {
    @Autowired
    InvoiceRepository repo;

    @PostMapping("/invoice")
    @ResponseStatus(HttpStatus.CREATED)
    public Invoice addInvoice (@RequestBody @Valid Invoice invoice){
        return repo.save(invoice);

    }

    @GetMapping("/invoices")
    @ResponseStatus(HttpStatus.OK)
    public List<Invoice> getInvoices() {
        return repo.findAll();
    }

    @GetMapping("/invoice/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Invoice getInvoiceById(@PathVariable @Valid int id) {
        Optional<Invoice> returnVal = repo.findById(id);
        if (returnVal.isPresent()) {
            return returnVal.get();
        } else {
            return null;
        }
    }
    @GetMapping("/invoice/name/{name}")
    @ResponseStatus(HttpStatus.OK)
    public List<Invoice> getInvoiceByName(@PathVariable String name) {
        return repo.findByName(name);
    }


}

