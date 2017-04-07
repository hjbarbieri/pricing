package com.hjbarbieri.model;

import java.util.List;

/**
 * Created by javierbarbieri on 06/04/2017.
 */
public abstract class Discount {

    private String productType;
    private Integer quantity;

    private String description;

    public Discount(String productType, Integer quantity, String description) {
        this.productType = productType;
        this.quantity = quantity;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    abstract Saving applyDiscount(List<Product> products);
}
