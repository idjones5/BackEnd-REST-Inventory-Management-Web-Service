package com.company.gamestore.fees.feerepo;

import com.company.gamestore.fees.feemodel.ProcessingFee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProcessingFeeRepository extends JpaRepository<ProcessingFee, Integer> {
    Optional<ProcessingFee> findAllByProductType(String type);
}
