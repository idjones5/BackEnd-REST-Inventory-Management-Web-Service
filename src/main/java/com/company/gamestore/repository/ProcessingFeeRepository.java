package com.company.gamestore.repository;

import com.company.gamestore.models.ProcessingFee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProcessingFeeRepository extends JpaRepository<ProcessingFee, Integer>{

    Optional<ProcessingFee> findAllByProductType(String productType);
}
