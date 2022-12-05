package com.company.gamestore.invoice.invoicecontoller;

import com.company.gamestore.service.InvoiceService;
import com.company.gamestore.viewmodel.InvoiceViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InvoiceController {

    @Autowired
    InvoiceService invoiceService;

    @PostMapping("/invoice")
    @ResponseStatus(HttpStatus.CREATED)
    public InvoiceViewModel createAndReturnInvoice(@RequestBody InvoiceViewModel viewModel) {
        return invoiceService.createAndReturnInvoice(viewModel);
    }
}
