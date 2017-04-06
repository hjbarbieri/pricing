package com.hjbarbieri.model;

/**
 * Created by javierbarbieri on 06/04/2017.
 */
public class Price {

    private Double price;
    private boolean isWeight;

    public Price(Double price) {
        this.price = price;
    }

    public Price(Double price, boolean isWeight) {
        this.price = price;
        this.isWeight = isWeight;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public boolean isWeight() {
        return isWeight;
    }

    public void setWeight(boolean weight) {
        isWeight = weight;
    }
}
