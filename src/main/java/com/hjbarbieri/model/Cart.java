package com.hjbarbieri.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by javierbarbieri on 06/04/2017.
 */
public class Cart {

    private List<Product> products;
    private List<Discount> discounts;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Discount> getDiscounts() {
        return discounts;
    }

    public void setDiscounts(List<Discount> discounts) {
        this.discounts = discounts;
    }

    public Receipt checkout() {
        Receipt receipt = new Receipt();

        receipt.setTotal(getTotal());
        receipt.setSavings(getSavings());
        receipt.setTotalSavings(getTotalSavings());

        return receipt;
    }

    private Double getTotalSavings() {
        return getSavings().stream().mapToDouble(p -> p.getSaving()).sum();
    }

    double getTotal() {
        return products.stream().mapToDouble(p -> p.getRealPrice()).sum();
    }

    public List<Saving> getSavings() {

        List<Saving> savings = new ArrayList<>();
        for (Discount discount: discounts) {
            savings.add(discount.applyDiscount(products));
        }
        return savings;
    }
}
