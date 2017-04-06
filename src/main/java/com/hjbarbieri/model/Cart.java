package com.hjbarbieri.model;

import java.util.List;

/**
 * Created by javierbarbieri on 06/04/2017.
 */
public class Cart {

    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Receipt checkout() {
        Receipt receipt = new Receipt();
        Double total = products.stream().mapToDouble(p -> p.getPrice().getPrice()).sum();

        receipt.setTotal(total);
        return receipt;
    }
}
