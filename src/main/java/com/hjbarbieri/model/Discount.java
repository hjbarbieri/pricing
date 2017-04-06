package com.hjbarbieri.model;

/**
 * Created by javierbarbieri on 06/04/2017.
 */
public class Discount {

    private String productType;
    private Integer quantity;
    private Integer percentage;

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

    public Integer getPercentage() {
        return percentage;
    }

    public void setPercentage(Integer percentage) {
        this.percentage = percentage;
    }
}
