package com.company.gamestore.tax.taxrepo;

import com.company.gamestore.tax.taxmodel.SalesTaxRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SalesTaxRepository extends JpaRepository<SalesTaxRate, Integer> {

    Optional<SalesTaxRate> findByState(String state);
}
