package com.company.gamestore.fees.feemodel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateInitializer", "handler"})
@Table(name = "processing_fee")
public class ProcessingFee implements Serializable {

    @Id
    @Column(name = "product_type")
    private String productType;
    private BigDecimal fee;

    public String getProduct_type() {
        return productType;
    }

    public void setProduct_type(String product_type) {
        this.productType = product_type;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProcessingFee that = (ProcessingFee) o;
        return Objects.equals(getProduct_type(), that.getProduct_type()) && Objects.equals(getFee(), that.getFee());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProduct_type(), getFee());
    }

    @Override
    public String toString() {
        return "ProcessingFee{" +
                "product_type='" + productType + '\'' +
                ", fee=" + fee +
                '}';
    }
}
