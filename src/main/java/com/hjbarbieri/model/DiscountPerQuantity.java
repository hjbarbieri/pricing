package com.hjbarbieri.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by javierbarbieri on 07/04/2017.
 */
public class DiscountPerQuantity extends Discount {

    private Integer discountQuantity;

    public DiscountPerQuantity(String productType, Integer quantity, Integer discountQuantity, String description) {
        super(productType, quantity, description);
        this.discountQuantity = discountQuantity;
    }

    @Override
    public Saving applyDiscount(List<Product> products) {
        Saving saving = new Saving();
        double save = getSavePrice(products);
        saving.setDescription(this.getDescription());
        saving.setSaving(save);

        return saving;
    }

    double getSavePrice(List<Product> products) {
        List<Product> productFiltered = products.stream().filter(p -> p.getType().equals(this.getProductType())).collect(Collectors.toList());
        if(productFiltered.size() == 0) {
            return 0;
        }
        int count = productFiltered.size();
        double price = productFiltered.get(0).getRealPrice();
        int qSaving = quantitySavings(this.getDiscountQuantity(), count);

        return qSaving * price;
    }

    int quantitySavings(int discount, int count) {
        return count / discount;
    }

    public Integer getDiscountQuantity() {
        return discountQuantity;
    }

    public void setDiscountQuantity(Integer discountQuantity) {
        this.discountQuantity = discountQuantity;
    }
}
