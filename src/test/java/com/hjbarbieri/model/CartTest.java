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
    public void whenIsNotDiscountForTheProductshouldNotApplyDiscount() {
        //given
        List<Product> products = initializeProducts();

        Cart cart = new Cart();
        cart.setProducts(products);

        // then
        Receipt receipt = cart.checkout();

        Assert.assertEquals(receipt.getTotal(), is(3.3));
    }

    private List<Product> initializeProducts() {
        List<Product> products = new ArrayList<>();
        Product productA = new Product("A", "Beans", new Price(0.5));
        products.add(productA);

        Product productB = new Product("B", "Coke", new Price(0.7));
        products.add(productB);

        Product productC = new Product("C", "Oranges", 0.2, new Price(1.99, true));
        products.add(productC);


        return products;
    }

}