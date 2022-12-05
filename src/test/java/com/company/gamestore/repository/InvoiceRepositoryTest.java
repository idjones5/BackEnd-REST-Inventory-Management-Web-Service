package com.company.gamestore.repository;

import com.company.gamestore.models.Invoice;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class InvoiceRepositoryTest {
    @Autowired
    InvoiceRepository invoiceRepository;

    @Before
    public void setUp() throws Exception {
        invoiceRepository.deleteAll();
    }
    @Test
    public void addGetInvoice(){
        Invoice invoice = new Invoice();
        invoice.setName("Patsy Serrano");
        invoice.setStreet("1234 Main St.");
        invoice.setCity("Huntington Beach");
        invoice.setZipcode("92649");
        invoice.setState("CA");
        invoice.setItemType("Tshirts");
        invoice.setItemId(118);
        invoice.setUnitPrice(new BigDecimal("23.99"));
        invoice.setQuantity(3);
        invoice.setSubTotal(new BigDecimal("71.97"));
        invoice.setProcessingFee(new BigDecimal("1.98"));
        invoice.setTax(new BigDecimal("4.32"));
        invoice.setTotal(new BigDecimal("78.24"));

        invoice = invoiceRepository.save(invoice);

        Optional< Invoice> invoice1 = invoiceRepository.findById(invoice.getId());

        assertEquals(invoice1.get(), invoice);
        invoice1= invoiceRepository.findById(invoice.getId());

        assertTrue(invoice1.isPresent());

    }
    @Test
    public void getInvoiceByName(){
        Invoice invoice = new Invoice();
        invoice.setName("Patsy Serrano");
        invoice.setStreet("1234 Main St.");
        invoice.setCity("Huntington Beach");
        invoice.setZipcode("92649");
        invoice.setState("CA");
        invoice.setItemType("Tshirts");
        invoice.setItemId(118);
        invoice.setUnitPrice(new BigDecimal("23.99"));
        invoice.setQuantity(3);
        invoice.setSubTotal(new BigDecimal("71.97"));
        invoice.setProcessingFee(new BigDecimal("1.98"));
        invoice.setTax(new BigDecimal("4.32"));
        invoice.setTotal(new BigDecimal("78.24"));


        invoice = invoiceRepository.save(invoice);

        invoice = new Invoice();
        invoice.setName("Alondra Serrano");
        invoice.setStreet("1234 2nd St.");
        invoice.setCity("Newport Beach");
        invoice.setZipcode("92649");
        invoice.setState("CA");
        invoice.setItemType("Tshirts");
        invoice.setItemId(112);
        invoice.setUnitPrice(new BigDecimal("23.99"));
        invoice.setQuantity(3);
        invoice.setSubTotal(new BigDecimal("71.97"));
        invoice.setProcessingFee(new BigDecimal("1.98"));
        invoice.setTax(new BigDecimal("4.32"));
        invoice.setTotal(new BigDecimal("78.24"));


        invoice = invoiceRepository.save(invoice);

        List<Invoice> invoiceList = invoiceRepository.findByName(invoice.getName());

        assertEquals(invoiceList.size(),1);

    }

    @Test
    public void getAllInvoices(){
        Invoice invoice = new Invoice();
        invoice.setName("Patsy Serrano");
        invoice.setStreet("1234 Main St.");
        invoice.setCity("Huntington Beach");
        invoice.setZipcode("92649");
        invoice.setState("CA");
        invoice.setItemType("Tshirts");
        invoice.setItemId(118);
        invoice.setUnitPrice(new BigDecimal("23.99"));
        invoice.setQuantity(3);
        invoice.setSubTotal(new BigDecimal("71.97"));
        invoice.setProcessingFee(new BigDecimal("1.98"));
        invoice.setTax(new BigDecimal("4.32"));
        invoice.setTotal(new BigDecimal("78.24"));


        invoice = invoiceRepository.save(invoice);

        invoice = new Invoice();
        invoice.setName("Alondra Serrano");
        invoice.setStreet("1234 2nd St.");
        invoice.setCity("Newport Beach");
        invoice.setZipcode("92649");
        invoice.setState("CA");
        invoice.setItemType("Tshirts");
        invoice.setItemId(112);
        invoice.setUnitPrice(new BigDecimal("23.99"));
        invoice.setQuantity(3);
        invoice.setSubTotal(new BigDecimal("71.97"));
        invoice.setProcessingFee(new BigDecimal("1.98"));
        invoice.setTax(new BigDecimal("4.32"));
        invoice.setTotal(new BigDecimal("78.24"));


        invoice = invoiceRepository.save(invoice);

        List<Invoice> invoiceList = invoiceRepository.findAll();

        assertEquals(invoiceList.size(),2);

    }

    @Test
    public void getAllInvoicesByName(){
        Invoice invoice = new Invoice();
        invoice.setName("Patsy Serrano");
        invoice.setStreet("1234 Main St.");
        invoice.setCity("Huntington Beach");
        invoice.setZipcode("92649");
        invoice.setState("CA");
        invoice.setItemType("Tshirts");
        invoice.setItemId(118);
        invoice.setUnitPrice(new BigDecimal("23.99"));
        invoice.setQuantity(3);
        invoice.setSubTotal(new BigDecimal("71.97"));
        invoice.setProcessingFee(new BigDecimal("1.98"));
        invoice.setTax(new BigDecimal("4.32"));
        invoice.setTotal(new BigDecimal("78.24"));


        invoice = invoiceRepository.save(invoice);

        invoice = new Invoice();
        invoice.setName("Patsy Serrano");
        invoice.setStreet("1234 2nd St.");
        invoice.setCity("Newport Beach");
        invoice.setZipcode("92649");
        invoice.setState("CA");
        invoice.setItemType("Tshirts");
        invoice.setItemId(112);
        invoice.setUnitPrice(new BigDecimal("23.99"));
        invoice.setQuantity(3);
        invoice.setSubTotal(new BigDecimal("71.97"));
        invoice.setProcessingFee(new BigDecimal("1.98"));
        invoice.setTax(new BigDecimal("4.32"));
        invoice.setTotal(new BigDecimal("78.24"));


        invoice = invoiceRepository.save(invoice);

        invoice = new Invoice();
        invoice.setName("Alondra Serrano");
        invoice.setStreet("1234 2nd St.");
        invoice.setCity("Newport Beach");
        invoice.setZipcode("92649");
        invoice.setState("CA");
        invoice.setItemType("Tshirts");
        invoice.setItemId(112);
        invoice.setUnitPrice(new BigDecimal("23.99"));
        invoice.setQuantity(3);
        invoice.setSubTotal(new BigDecimal("71.97"));
        invoice.setProcessingFee(new BigDecimal("1.98"));
        invoice.setTax(new BigDecimal("4.32"));
        invoice.setTotal(new BigDecimal("78.24"));

        invoice = invoiceRepository.save(invoice);

        List<Invoice> invoiceList = invoiceRepository.findAllByName("Patsy Serrano");

        assertEquals(invoiceList.size(),2);

    }
}