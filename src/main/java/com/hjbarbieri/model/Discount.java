package com.hjbarbieri.model;

/**
 * Created by javierbarbieri on 06/04/2017.
 */
public class Discount {

    private String productType;
    private Integer quantity;
    private Integer discount;
    private double multiplePrice;
    private String description;

    public Discount(String productType, Integer quantity, Integer discount, String description) {
        this.productType = productType;
        this.quantity = quantity;
        this.discount = discount;
        this.description = description;
    }

    public Discount(String productType, Integer quantity, double multiplePrice, String description) {
        this.productType = productType;
        this.quantity = quantity;
        this.multiplePrice = multiplePrice;
        this.description = description;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getMultiplePrice() {
        return multiplePrice;
    }

    public void setMultiplePrice(double multiplePrice) {
        this.multiplePrice = multiplePrice;
    }
}
