package com.hjbarbieri.model;

/**
 * Created by javierbarbieri on 06/04/2017.
 */
public class Product {

    private String type;
    private String description;
    private Double weight;
    private Price price;

    public Product(String type, String description, Price price) {
        this.type = type;
        this.description = description;
        this.price = price;
    }

    public Product(String type, String description, Double weight, Price price) {
        this.type = type;
        this.description = description;
        this.price = price;
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getRealPrice() {
        if(weight == null) {
            return price.getPrice();
        }

        return (double) Math.round(price.getWeightPrice(weight) * 100) / 100;
    }
}
