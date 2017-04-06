package com.hjbarbieri.model;

import java.util.List;

/**
 * Created by javierbarbieri on 06/04/2017.
 */
public class Receipt {

    private List<Product> products;
    private List<Saving> savings;

    private Double total;
    private Double totalSavings;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Saving> getSavings() {
        return savings;
    }

    public void setSavings(List<Saving> savings) {
        this.savings = savings;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getTotalSavings() {
        return totalSavings;
    }

    public void setTotalSavings(Double totalSavings) {
        this.totalSavings = totalSavings;
    }
}
