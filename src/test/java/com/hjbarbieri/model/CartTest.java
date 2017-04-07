package com.hjbarbieri.model;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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