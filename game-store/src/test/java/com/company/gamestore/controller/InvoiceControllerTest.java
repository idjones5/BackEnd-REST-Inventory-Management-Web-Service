package com.company.gamestore.controller;

import com.company.gamestore.model.Invoice;
import com.company.gamestore.repository.InvoiceRepository;
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
    private InvoiceRepository invoiceRepository;

    // ObjectMapper used to convert Java objects to JSON and vice versa
    private ObjectMapper mapper = new ObjectMapper();
    Invoice invoice = new Invoice();

    private List<Invoice> invoiceList;

    @Before
    public void Setup() throws Exception{
        invoice.setCity("Hampton");
        invoice.setQuantity(3);
        invoice.setName("John");
        invoice.setItemId(1);
        invoice.setState("VA");
        invoice.setItemType("Game");
        invoice.setZipcode("23444");
        invoice.setStreet("Virginia Beach street");
        invoice.setProcessingFee(new BigDecimal(4.11));
        invoice.setUnitPrice(new BigDecimal(140.99));
        invoice.setTax(new BigDecimal(3.22));
        invoice.setSubTotal(new BigDecimal(150.55));
        invoice.setTotal(new BigDecimal(155.71));
    }

    @Test
    public void shouldGetInvoiceById() throws Exception {
        invoice.setId(2);
        String outputJson = mapper.writeValueAsString(invoice);

        mockMvc.perform(get("/invoice/2").content(outputJson).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldGetAllInvoices() throws Exception{
        // ARRANGE
        // Convert Java object to JSON
        String outputJson = mapper.writeValueAsString(invoiceList);

        // ACT
        mockMvc.perform(get("/invoice").content(outputJson).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))                // Perform the GET request
                .andDo(print())                          // Print results to console
                .andExpect(status().isOk());              // ASSERT (status code is 200)
    }

    @Test
    public void shouldGetInvoiceByName() throws Exception{
        // ARRANGE
        // Convert Java object to JSON
        String outputJson = mapper.writeValueAsString(invoiceList);

        // ACT
        mockMvc.perform(get("/invoice/name/John").content(outputJson).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))                // Perform the GET request
                .andDo(print())                          // Print results to console
                .andExpect(status().isOk());              // ASSERT (status code is 200)
    }

    @Test
    public void shouldAddInvoice() throws Exception{
        // Convert Java Object to JSON
        String inputJson = mapper.writeValueAsString(invoice);

        // ACT
        mockMvc.perform(
                        post("/invoice")                            // Perform the POST request
                                .content(inputJson)                       // Set the request body
                                .contentType(MediaType.APPLICATION_JSON)  // Tell the server it's in JSON format
                )
                .andDo(print())                                // Print results to console
                .andExpect(status().isCreated());              // ASSERT (status code is 201)
    }

}
