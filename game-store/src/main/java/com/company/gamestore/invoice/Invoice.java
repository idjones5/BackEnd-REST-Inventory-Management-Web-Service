package com.company.gamestore.invoice;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateInitializer", "handler"})
@Table(name = "invoice")
public class Invoice implements Serializable {

    @Id
    @Column(name = "invoice_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer invoiceId;
    private String name;
    private String street;
    private String city;
    @Size(min = 2, max = 2)
    private String state;
    private String zipcode;
    private String itemType;
    private int itemId;
    private BigDecimal unitPrice;
    private int quantity;
    private BigDecimal subTotal;
    private BigDecimal tax;
    private BigDecimal processingFee;
    private BigDecimal total;

    public Integer getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public BigDecimal getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(BigDecimal processingFee) {
        this.processingFee = processingFee;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return getQuantity() == invoice.getQuantity() && Objects.equals(getInvoiceId(), invoice.getInvoiceId()) && Objects.equals(getName(), invoice.getName()) && Objects.equals(getStreet(), invoice.getStreet()) && Objects.equals(getCity(), invoice.getCity()) && Objects.equals(getState(), invoice.getState()) && Objects.equals(getZipcode(), invoice.getZipcode()) && Objects.equals(getItemType(), invoice.getItemType()) && Objects.equals(getItemId(), invoice.getItemId()) && Objects.equals(getUnitPrice(), invoice.getUnitPrice()) && Objects.equals(getSubTotal(), invoice.getSubTotal()) && Objects.equals(getTax(), invoice.getTax()) && Objects.equals(getProcessingFee(), invoice.getProcessingFee()) && Objects.equals(getTotal(), invoice.getTotal());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getInvoiceId(), getName(), getStreet(), getCity(), getState(), getZipcode(), getItemType(), getItemId(), getUnitPrice(), getQuantity(), getSubTotal(), getTax(), getProcessingFee(), getTotal());
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "invoiceId=" + invoiceId +
                ", name='" + name + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", itemType='" + itemType + '\'' +
                ", itemId='" + itemId + '\'' +
                ", unitPrice=" + unitPrice +
                ", quantity=" + quantity +
                ", subTotal=" + subTotal +
                ", tax=" + tax +
                ", processingFee=" + processingFee +
                ", total=" + total +
                '}';
    }
}
