package com.hjbarbieri.model;

import org.junit.Assert;
import org.junit.Test;

import static com.sun.org.apache.xerces.internal.util.PropertyState.is;

/**
 * Created by javierbarbieri on 06/04/2017.
 */
public class ProductTest {

    @Test
    public void whenWeightIsNullThenPriceIsPrice() {
        //give
        Price price = new Price(2.2);
        Product product = new Product("A", "Beans", price);

        //then

        Assert.assertTrue(product.getRealPrice().equals(2.2));
    }

    @Test
    public void whenWeightIsAddedThenPriceIsPercentagePrice() {
        //give
        Product product = new Product("C", "Oranges", 0.2, new Price(1.99, true));
        //then

        Assert.assertTrue(product.getRealPrice().equals(0.4d));
    }
}
