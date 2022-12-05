package com.company.gamestore.controller;

import com.company.gamestore.models.Invoice;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(InvoiceController.class)
public class InvoiceControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private InvoiceController invoiceController;

    // ObjectMapper used to convert Java objects to JSON and vice versa
    private ObjectMapper mapper = new ObjectMapper();

    // A list of Invoice for testing purpose
    private List<Invoice> invoiceList;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void shouldAddInvoice() throws Exception{
        Invoice inputInvoice = new Invoice();

        inputInvoice.setName("Patsy Serrano");
        inputInvoice.setStreet("1234 Main St.");
        inputInvoice.setCity("Huntington Beach");
        inputInvoice.setZipcode("92649");
        inputInvoice.setState("CA");
        inputInvoice.setItemType("Tshirts");
        inputInvoice.setItemId(118);
        inputInvoice.setUnitPrice(new BigDecimal("23.99"));
        inputInvoice.setQuantity(3);
        inputInvoice.setSubTotal(new BigDecimal("71.97"));
        inputInvoice.setProcessingFee(new BigDecimal("1.98"));
        inputInvoice.setTax(new BigDecimal("4.32"));
        inputInvoice.setTotal(new BigDecimal("78.24"));

        String inputJson = mapper.writeValueAsString(inputInvoice);

        Invoice outputInvoice = new Invoice();
        outputInvoice.setName("Patsy Serrano");
        outputInvoice.setStreet("1234 Main St.");
        outputInvoice.setCity("Huntington Beach");
        outputInvoice.setZipcode("92649");
        outputInvoice.setState("CA");
        outputInvoice.setItemType("Tshirts");
        outputInvoice.setItemId(118);
        outputInvoice.setUnitPrice(new BigDecimal("23.99"));
        outputInvoice.setQuantity(3);
        outputInvoice.setSubTotal(new BigDecimal("71.97"));
        outputInvoice.setProcessingFee(new BigDecimal("1.98"));
        outputInvoice.setTax(new BigDecimal("4.32"));
        outputInvoice.setTotal(new BigDecimal("78.24"));
        outputInvoice.setId(1);

        String outputJson = mapper.writeValueAsString(outputInvoice);

        mockMvc.perform(
                        post("/invoice")                            // Perform the POST request
                                .content(inputJson)                       // Set the request body
                                .contentType(MediaType.APPLICATION_JSON)  // Tell the server it's in JSON format
                )
                .andDo(print())                                // Print results to console
                .andExpect(status().isCreated());          // ASSERT (Status code is 201)

    }

    @Test
    public void shouldGetAllInvoices() throws Exception{
        Invoice inputInvoice = new Invoice();

        inputInvoice.setName("Alondra Genesis");
        inputInvoice.setStreet("1234 2nd St.");
        inputInvoice.setCity("Huntington Beach");
        inputInvoice.setZipcode("92647");
        inputInvoice.setState("CA");
        inputInvoice.setItemType("Tshirts");
        inputInvoice.setItemId(118);
        inputInvoice.setUnitPrice(new BigDecimal("23.99"));
        inputInvoice.setQuantity(3);
        inputInvoice.setSubTotal(new BigDecimal("71.97"));
        inputInvoice.setProcessingFee(new BigDecimal("1.98"));
        inputInvoice.setTax(new BigDecimal("4.32"));
        inputInvoice.setTotal(new BigDecimal("78.24"));
        inputInvoice.setId(5);

        String inputJson = mapper.writeValueAsString(inputInvoice);

        Invoice outputInvoice = new Invoice();
        outputInvoice.setName("Patsy Serrano");
        outputInvoice.setStreet("1234 Main St.");
        outputInvoice.setCity("Huntington Beach");
        outputInvoice.setZipcode("92649");
        outputInvoice.setState("CA");
        outputInvoice.setItemType("Tshirts");
        outputInvoice.setItemId(118);
        outputInvoice.setUnitPrice(new BigDecimal("23.99"));
        outputInvoice.setQuantity(3);
        outputInvoice.setSubTotal(new BigDecimal("71.97"));
        outputInvoice.setProcessingFee(new BigDecimal("1.98"));
        outputInvoice.setTax(new BigDecimal("4.32"));
        outputInvoice.setTotal(new BigDecimal("78.24"));
        outputInvoice.setId(1);

        String outputJson = mapper.writeValueAsString(outputInvoice);

        mockMvc.perform(get("/invoices"))
                .andDo(print())
                .andExpect(status().isOk());

    }


    @Test
    public void shouldGetInvoiceById() throws Exception{
        Invoice outputInvoice = new Invoice();
        outputInvoice.setName("Patsy Serrano");
        outputInvoice.setStreet("1234 Main St.");
        outputInvoice.setCity("Huntington Beach");
        outputInvoice.setZipcode("92649");
        outputInvoice.setState("CA");
        outputInvoice.setItemType("Tshirts");
        outputInvoice.setItemId(118);
        outputInvoice.setUnitPrice(new BigDecimal("23.99"));
        outputInvoice.setQuantity(3);
        outputInvoice.setSubTotal(new BigDecimal("71.97"));
        outputInvoice.setProcessingFee(new BigDecimal("1.98"));
        outputInvoice.setTax(new BigDecimal("4.32"));
        outputInvoice.setTotal(new BigDecimal("78.24"));
        outputInvoice.setId(1);

        String outputJson = mapper.writeValueAsString(outputInvoice);

        mockMvc.perform(get("/invoice/id/1"))
                .andDo(print())
                .andExpect(status().isOk());

    }


    @Test
    public void shouldGetInvoiceByName() throws Exception{
        Invoice inputInvoice = new Invoice();

        inputInvoice.setName("Alondra Genesis");
        inputInvoice.setStreet("1234 2nd St.");
        inputInvoice.setCity("Huntington Beach");
        inputInvoice.setZipcode("92647");
        inputInvoice.setState("CA");
        inputInvoice.setItemType("Tshirts");
        inputInvoice.setItemId(118);
        inputInvoice.setUnitPrice(new BigDecimal("23.99"));
        inputInvoice.setQuantity(3);
        inputInvoice.setSubTotal(new BigDecimal("71.97"));
        inputInvoice.setProcessingFee(new BigDecimal("1.98"));
        inputInvoice.setTax(new BigDecimal("4.32"));
        inputInvoice.setTotal(new BigDecimal("78.24"));
        inputInvoice.setId(5);

        String inputJson = mapper.writeValueAsString(inputInvoice);

        Invoice outputInvoice = new Invoice();
        outputInvoice.setName("Patsy Serrano");
        outputInvoice.setStreet("1234 Main St.");
        outputInvoice.setCity("Huntington Beach");
        outputInvoice.setZipcode("92649");
        outputInvoice.setState("CA");
        outputInvoice.setItemType("Tshirts");
        outputInvoice.setItemId(118);
        outputInvoice.setUnitPrice(new BigDecimal("23.99"));
        outputInvoice.setQuantity(3);
        outputInvoice.setSubTotal(new BigDecimal("71.97"));
        outputInvoice.setProcessingFee(new BigDecimal("1.98"));
        outputInvoice.setTax(new BigDecimal("4.32"));
        outputInvoice.setTotal(new BigDecimal("78.24"));
        outputInvoice.setId(1);

        String outputJson = mapper.writeValueAsString(outputInvoice);

        mockMvc.perform(get("/invoice/name/patsy_serrano"))
                .andDo(print())
                .andExpect(status().isOk());

    }


}