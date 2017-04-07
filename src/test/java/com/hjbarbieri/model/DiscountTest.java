package com.hjbarbieri.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by javierbarbieri on 07/04/2017.
 */
public class DiscountTest {

    List<Product> products;
    List<Discount> discounts;

    @Before
    public void before() {
        products = initializeProducts();
        discounts = initializeDiscounts();
    }

    @Test
    public void shouldSumAParticularSavings() {
        //given


        Discount discount = discounts.get(0);

        // then
        Saving saving = discount.applyDiscount(products);

        Assert.assertTrue(saving.getSaving() == 0.5);
    }

    @Test
    public void shouldSumAllSavingsAndAllDiscounts() {
        //given

        Discount discount = discounts.get(0);

        // then
        Saving saving = discount.applyDiscount(products);
        double total = saving.getSaving();

        Assert.assertTrue(total == 0.5);
    }

    @Test
    public void shouldFindQuantitiesOfDiscountProductWhenSizeIsEqualToDiscount() {
        //given

        Discount discount = new DiscountPerQuantity("A", 3, 6, "Beans 3 for 2 ");

        // then
        double total = ((DiscountPerQuantity) discount).quantitySavings(3,6);

        Assert.assertTrue(total == 2);

    }

    @Test
    public void shouldFindQuantitiesOfDiscountProductWhenSizeIsDifferentThanDiscount() {
        //given

        Discount discount = new DiscountPerQuantity("A", 3, 5, "Beans 3 for 2 ");

        // then
        double total = ((DiscountPerQuantity) discount).quantitySavings(3,5);

        Assert.assertTrue(total == 1);

    }

    @Test
    public void shouldGetPriceWithDiscount() {
        //Given
        DiscountPerValue discount = (DiscountPerValue) discounts.get(1);

        //then
        Double priceWithDiscount = discount.getPriceWithDiscountPerItem();

        Assert.assertTrue(priceWithDiscount == 0.5);


    }

    private List<Discount> initializeDiscounts() {
        List<Discount> discounts = new ArrayList<>();
        Discount discountA = new DiscountPerQuantity("A", Integer.valueOf(3), Integer.valueOf(1), "Beans 3 for 2 ");
        discounts.add(discountA);

        Discount discountB = new DiscountPerValue("B", Integer.valueOf(2), "Coke 2 for £1   ", Double.valueOf(1));
        discounts.add(discountB);



        return discounts;
    }

    @Test
    public void shouldSumAllSavingsAndAllDiscountsForB() {
        //given

        Discount discount = discounts.get(1);

        // then
        Saving saving = discount.applyDiscount(products);
        double total = saving.getSaving();

        Assert.assertTrue(total == 0.4);
    }



    private List<Product> initializeProducts() {
        List<Product> products = new ArrayList<>();
        Product productA = new Product("A", "Beans", new Price(0.5));
        products.add(productA);

        Product productA1 = new Product("A", "Beans", new Price(0.5));
        products.add(productA1);

        Product productA2 = new Product("A", "Beans", new Price(0.5));
        products.add(productA2);

        Product productB = new Product("B", "Coke", new Price(0.7));
        products.add(productB);

        Product productB1 = new Product("B", "Coke", new Price(0.7));
        products.add(productB1);

        Product productC = new Product("C", "Oranges", 0.2, new Price(1.99, true));
        products.add(productC);


        return products;
    }
}
