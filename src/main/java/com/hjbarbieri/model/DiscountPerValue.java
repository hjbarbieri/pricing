package com.hjbarbieri.model;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by javierbarbieri on 07/04/2017.
 */
public class DiscountPerValue extends Discount {

    private double multiplePrice;

    public DiscountPerValue(String productType, Integer quantity, String description, double multiplePrice) {
        super(productType, quantity, description);
        this.multiplePrice = multiplePrice;
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
        double priceWithDiscount = getPriceWithDiscountPerItem();
        int count = productFiltered.size();
        double savePricePerItem = productFiltered.get(0).getRealPrice() - priceWithDiscount;
        savePricePerItem = (double) Math.round(savePricePerItem * 100) / 100;
        int qSaving = quantitySavings(this.getQuantity(), count) * count;

        return qSaving * savePricePerItem;
    }

    double getPriceWithDiscountPerItem() {
        return this.multiplePrice / this.getQuantity();
    }

    int quantitySavings(int discount, int count) {
        return count / discount;
    }

    public double getMultiplePrice() {
        return multiplePrice;
    }

    public void setMultiplePrice(double multiplePrice) {
        this.multiplePrice = multiplePrice;
    }
}
