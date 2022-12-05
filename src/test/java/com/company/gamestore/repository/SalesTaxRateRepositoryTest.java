package com.company.gamestore.repository;

import com.company.gamestore.models.SalesTaxRate;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SalesTaxRateRepositoryTest {
    @Autowired
    SalesTaxRepository salesTaxRateRepository;

    @Before
    public void setUp() throws Exception {
        salesTaxRateRepository.deleteAll();
    }

    @Test
    public void findSalesTaxRateByState(){
        SalesTaxRate salesTaxRate = new SalesTaxRate();
        salesTaxRate.setRate(new BigDecimal(".06"));
        salesTaxRate.setState("CA");
        salesTaxRate = salesTaxRateRepository.save(salesTaxRate);

        Optional<SalesTaxRate> salesTaxRate1 = salesTaxRateRepository.findByState("CA");
        assertEquals(salesTaxRate1.get(), salesTaxRate);

    }
}