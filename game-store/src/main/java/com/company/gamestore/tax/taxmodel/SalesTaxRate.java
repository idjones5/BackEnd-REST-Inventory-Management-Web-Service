package com.company.gamestore.tax.taxmodel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateInitializer", "handler"})
@Table(name = "sales_tax_rate")
public class SalesTaxRate implements Serializable {

    @Id
    @Column(name = "state")
    private String state;
    private BigDecimal rate;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SalesTaxRate salesTaxRate = (SalesTaxRate) o;
        return Objects.equals(getState(), salesTaxRate.getState()) && Objects.equals(getRate(), salesTaxRate.getRate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getState(), getRate());
    }

    @Override
    public String toString() {
        return "Tax{" +
                "state='" + state + '\'' +
                ", rate=" + rate +
                '}';
    }
}
