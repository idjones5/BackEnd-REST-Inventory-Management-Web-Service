package com.company.gamestore.viewmodel;

import com.company.gamestore.models.Invoice;
import com.company.gamestore.models.ProcessingFee;
import com.company.gamestore.models.SalesTaxRate;
import com.company.gamestore.models.Tshirt;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Objects;

public class InvoiceViewModel {

    private int id;
    private Invoice invoice;
    private Tshirt tshirt;
    private String name;
    private String street;
    private String city;
    @NotNull
    @Size(min = 2, max = 2)
    private String state;
    private String zipcode;
    private SalesTaxRate salesTaxRate;
    private int quantity;
    private String itemType;
    private int itemId;
    private BigDecimal unitPrice;
    private BigDecimal tax;
    private BigDecimal total;
    private BigDecimal processingFee;
    private BigDecimal subTotal;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Tshirt getTshirt() {
        return tshirt;
    }

    public void setTshirt(Tshirt tshirt) {
        this.tshirt = tshirt;
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

    public SalesTaxRate getSalesTaxRate() {
        return salesTaxRate;
    }

    public void setSalesTaxRate(SalesTaxRate salesTaxRate) {
        this.salesTaxRate = salesTaxRate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(BigDecimal processingFee) {
        this.processingFee = processingFee;
    }

    public BigDecimal getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceViewModel that = (InvoiceViewModel) o;
        return getId() == that.getId() && getQuantity() == that.getQuantity() && getItemId() == that.getItemId() && Objects.equals(getInvoice(), that.getInvoice()) && Objects.equals(getTshirt(), that.getTshirt()) && Objects.equals(getName(), that.getName()) && Objects.equals(getStreet(), that.getStreet()) && Objects.equals(getCity(), that.getCity()) && Objects.equals(getState(), that.getState()) && Objects.equals(getZipcode(), that.getZipcode()) && Objects.equals(getSalesTaxRate(), that.getSalesTaxRate()) && Objects.equals(getItemType(), that.getItemType()) && Objects.equals(getUnitPrice(), that.getUnitPrice()) && Objects.equals(getTax(), that.getTax()) && Objects.equals(getTotal(), that.getTotal()) && Objects.equals(getProcessingFee(), that.getProcessingFee()) && Objects.equals(getSubTotal(), that.getSubTotal());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getInvoice(), getTshirt(), getName(), getStreet(), getCity(), getState(), getZipcode(), getSalesTaxRate(), getQuantity(), getItemType(), getItemId(), getUnitPrice(), getTax(), getTotal(), getProcessingFee(), getSubTotal());
    }

    @Override
    public String toString() {
        return "InvoiceViewModel{" +
                "id=" + id +
                ", invoice=" + invoice +
                ", tshirt=" + tshirt +
                ", name='" + name + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", salesTaxRate=" + salesTaxRate +
                ", quantity=" + quantity +
                ", itemType='" + itemType + '\'' +
                ", itemId=" + itemId +
                ", unitPrice=" + unitPrice +
                ", tax=" + tax +
                ", total=" + total +
                ", processingFee=" + processingFee +
                ", subTotal=" + subTotal +
                '}';
    }
}
