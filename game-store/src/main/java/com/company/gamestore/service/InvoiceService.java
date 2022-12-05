package com.company.gamestore.service;

import com.company.gamestore.fees.feemodel.ProcessingFee;
import com.company.gamestore.fees.feerepo.ProcessingFeeRepository;
import com.company.gamestore.game.gamemodel.Game;
import com.company.gamestore.game.gamerepo.GameRepository;
import com.company.gamestore.invoice.Invoice;
import com.company.gamestore.tax.taxmodel.SalesTaxRate;
import com.company.gamestore.tax.taxrepo.SalesTaxRepository;
import com.company.gamestore.viewmodel.InvoiceViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {

    @Autowired
    ProcessingFeeRepository processingFeeRepository;
    @Autowired
    GameRepository gameRepository;
    @Autowired
    SalesTaxRepository salesTaxRepository;
//    @Autowired
//    ConsoleRepository consoleRepository;
//    @Autowired
//    TshirtRepository tshirtRepository;

    @Autowired
    public InvoiceService(ProcessingFeeRepository processingFeeRepository, GameRepository gameRepository, SalesTaxRepository salesTaxRepository) {
        this.processingFeeRepository = processingFeeRepository;
        this.gameRepository = gameRepository;
        this.salesTaxRepository = salesTaxRepository;
    }


//    Sales tax applies only to the cost of the items.
//    Sales tax does not apply to any processing fees for an invoice.
//    The processing fee is applied only once per order, regardless of the number of items in the order, unless the number of items in the order is greater than 10, in which case an additional processing fee of $15.49 is applied to the order.
//    The order-processing logic must properly update the quantity available for the item in the order.
//    Order quantity must be greater than zero.
//    Order quantity must be less than or equal to the number of items available in inventory.
//    The order must contain a valid state code.
//    The REST API must properly handle and report all violations of business rules.


    @Transactional
    public InvoiceViewModel createAndReturnInvoice(@RequestBody InvoiceViewModel viewModel) {

        // invoice model to be added to the database
        Invoice invoice = new Invoice();

        // setting the known values from the view model to the invoice
        invoice.setName(viewModel.getName());
        invoice.setState(viewModel.getState());
        invoice.setStreet(viewModel.getStreet());
        invoice.setCity(viewModel.getCity());
        invoice.setZipcode(viewModel.getZipcode());
        invoice.setItemType(viewModel.getItemType());
        invoice.setItemId(viewModel.getItemId());
        invoice.setQuantity(viewModel.getQuantity());

        // short list of possible game entry options
        List<String> consoleStringList = Arrays.asList("console", "Console", "CONSOLE");
        List<String> gameStringList = Arrays.asList("game", "Game", "GAME");
        List<String> tshirtStringList = Arrays.asList("t-shirt", "T-Shirt", "tshirt", "Tshirt");


        if (consoleStringList.contains(invoice.getItemType())) {
//
//            Console console = consoleRepository.findById(invoice.getItemId()).orElseThrow(() ->
//                    new NullPointerException("Console does not exist")
//            );
//
//            // setting the type to how it is in the repository
//            invoice.setItemType("Console");
//
//            //Ensure that quantity of specific item is available; If so, reduce quantity by quantity provided by user
//            if(console.getQuantity() >= invoice.getQuantity()) {
//                //reduce quantity in DB by invoice quantity
//                console.setQuantity(console.getQuantity() - invoice.getQuantity());
//                consoleRepository.save(console);  //update console
//            } else{
//                throw new IllegalArgumentException("Not enough in stock");
//            }
//
        } else if (gameStringList.contains(invoice.getItemType())) {

            // looking for the game in the repository and throwing null exception if not found
            Game game = gameRepository.findById(invoice.getItemId()).orElseThrow(() ->
                    new NullPointerException("Game does not exist")
            );

            // setting the type to how it is in the repository
            invoice.setItemType("Game");

            // getting the price of the game from the database
            invoice.setUnitPrice(game.getPrice());

            //Ensure that quantity of specific item is available; If so, reduce quantity by quantity provided by user
            if(game.getQuantity() >= invoice.getQuantity()) {
                //reduce quantity in DB by invoice quantity
                game.setQuantity(game.getQuantity() - invoice.getQuantity());
                gameRepository.save(game);  //update game
            } else {
                throw new IllegalArgumentException("Not enough in stock.");
            }

        } else if(tshirtStringList.contains(invoice.getItemType())) {
//
//            // looking for the game in the repository and throwing null exception if not found
//            Tshirt tshirt = tshirtRepository.findById(invoice.getItemId()).orElseThrow(() ->
//                    new NullPointerException("T-shirt does not exist")
//            );

//            // setting the type to how it is in the repository
//            invoice.setItemType("T-Shirt");
//
//           //If item exists, set unit price using price from the item's table
//            invoice.setUnitPrice(tshirt.getPrice());
//
//            //Ensure that quantity of specific item is available; If so, reduce quantity by quantity provided by user
//            if(tshirt.get().getQuantity() >= invoice.getQuantity()) {
//                //reduce quantity in DB by invoice quantity
//                tshirt.get().setQuantity(tshirt.get().getQuantity() - invoice.getQuantity());
//                tshirtRepository.save(tshirt.get());  //update tshirt
//            } else {
//                throw new IllegalArgumentException("Not enough in stock");
//            }
//
        } else {
            throw new IllegalArgumentException("Invalid argument.");
        }

        //Ensure that state entered is valid
        Optional<SalesTaxRate> salesTaxRate = salesTaxRepository.findByState(invoice.getState());

        if(!salesTaxRate.isPresent()) {
            throw new IllegalArgumentException("Sales tax not found");
        }

        //Select processing fee based on quantity of items;
        //if quantity > 10, processingFee = 15.49 + processingFee from fee table,
        //else, processingFee = processingFee from fee table
        Optional<ProcessingFee> processingFee = processingFeeRepository.findAllByProductType(invoice.getItemType());

        if(invoice.getQuantity() <= 10) {
            invoice.setProcessingFee(processingFee.get().getFee());
        } else {
            invoice.setProcessingFee(processingFee.get().getFee().add(new BigDecimal("15.49")));
        }

        //Calculate subtotal as (unit price * quantity)
        invoice.setSubTotal(invoice.getUnitPrice().multiply(BigDecimal.valueOf(invoice.getQuantity())));

        //Get tax based on state and Calculate sales tax as (sales tax = tax * subtotal)
        invoice.setTax(salesTaxRate.get().getRate().multiply(invoice.getSubTotal()));

        //Calculate total as total = subtotal + sales tax + processing fee and save
        invoice.setTotal(invoice.getSubTotal().add(invoice.getTax().add(invoice.getProcessingFee())));

//        invoice = invoiceRepository.save(invoice);

        return buildInvoiceViewModel(invoice);
    }

//    public InvoiceViewModel findInvoice (int id){
//        Optional<Invoice> invoice = invoiceRepository.findById(id);
//
//        return invoice.isPresent() ? buildInvoiceViewModel(invoice.get()):null;
//    }
//
//    public List<InvoiceViewModel> findAllInvoices() {
//        List<InvoiceViewModel> invoiceViewModels = null;
//        List<Invoice> invoices = invoiceRepository.findAll();
//
//        invoices.stream().forEach(t -> invoiceViewModels.add(buildInvoiceViewModel(t)));
//        return invoiceViewModels;
//    }
//
//    public List<InvoiceViewModel> findAllInvoicesByName(String name){
//        List<InvoiceViewModel> invoiceViewModels = null;
//        List<Invoice> invoices = invoiceRepository.findAllByName(name);
//
//        invoices.stream().forEach(t -> invoiceViewModels.add(buildInvoiceViewModel(t)));
//        return invoiceViewModels;
//    }

    private InvoiceViewModel buildInvoiceViewModel(Invoice invoice) {
        //Assemble the invoice view model
        InvoiceViewModel avm = new InvoiceViewModel();

        avm.setUnitPrice(invoice.getUnitPrice());
        avm.setTax(invoice.getTax());
        avm.setStreet(invoice.getStreet());
        avm.setZipcode(invoice.getZipcode());
        avm.setState(invoice.getState());
        avm.setSubTotal(invoice.getSubTotal());
        avm.setName(invoice.getName());
        avm.setQuantity(invoice.getQuantity());
        avm.setCity(invoice.getCity());
        avm.setProcessingFee(invoice.getProcessingFee());
        avm.setTotal(invoice.getTotal());
        avm.setItemType(invoice.getItemType());
        avm.setItemId(invoice.getItemId());

        return avm;
    }

//    // normalizing the type to reduce error when processing
//    public String normalizeItemType(String type) {
//        type = type.replaceAll("[^a-zA-Z0-9]", "");
//        type = type.toLowerCase();
//        return type;
//    }
}
