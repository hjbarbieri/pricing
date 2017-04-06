package com.hjbarbieri.model;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.sun.org.apache.xerces.internal.util.PropertyState.is;
import static org.junit.Assert.*;

/**
 * Created by javierbarbieri on 06/04/2017.
 */
public class CartTest {


    @Test
    public void shouldSumAllProducts() {
        //given
        List<Product> products = initializeProducts();

        Cart cart = new Cart();
        cart.setProducts(products);

        // then
        double total = cart.getTotal();

        Assert.assertTrue(total == 3.3);
    }

    @Test
    public void shouldSumAParticularSavings() {
        //given
        List<Product> products = initializeProducts();
        List<Discount> discounts = initializeDiscounts();

        Cart cart = new Cart();
        cart.setProducts(products);
        cart.setDiscounts(discounts);

        // then
        double total = cart.getSavePrice(discounts.get(0));

        Assert.assertTrue(total == 0.5);
    }

    @Test
    public void shouldSumAllSavingsAndAllDiscounts() {
        //given
        List<Product> products = initializeProducts();
        List<Discount> discounts = initializeDiscounts();

        Cart cart = new Cart();
        cart.setProducts(products);
        cart.setDiscounts(discounts);

        // then
        double total = cart.getSavePrice(discounts.get(0));

        Assert.assertTrue(total == 0.5);
    }

    @Test
    public void shouldFindQuantitiesOfDiscountProductWhenSizeIsEqualToDiscount() {
        //given

        Cart cart = new Cart();

        // then
        double total = cart.quantitySavings(3,6);

        Assert.assertTrue(total == 2);

    }

    @Test
    public void shouldFindQuantitiesOfDiscountProductWhenSizeIsDifferentThanDiscount() {
        //given

        Cart cart = new Cart();

        // then
        double total = cart.quantitySavings(3,5);

        Assert.assertTrue(total == 1);

    }

    private List<Discount> initializeDiscounts() {
        List<Discount> discounts = new ArrayList<>();
        Discount discountA = new Discount("A", Integer.valueOf(3), Integer.valueOf(1), "Beans 3 for 2 ");
        discounts.add(discountA);

        Discount discountB = new Discount("B", 2, 1d, "Coke 2 for £1") ;
        discounts.add(discountB);

        return discounts;
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