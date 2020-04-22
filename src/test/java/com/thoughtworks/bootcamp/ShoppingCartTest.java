package com.thoughtworks.bootcamp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ShoppingCartTest {
    @Test
    void givenEmptyShoppingCart_whenAddOneApple_thenShouldReturnTotalCartPriceZeroPointNineNine() {
        ShoppingCart shoppingCart = new ShoppingCart("apple", 1, 0.99);

        double cartTotal = shoppingCart.calculateTotalCart();

        Assertions.assertEquals(0.99, cartTotal);

    }

    @Test
    void givenEmptyShoppingCart_whenAddFiveApple_thenShouldReturnTotalCartPriceZeroPointNineNine() {
        ShoppingCart shoppingCart = new ShoppingCart("apple", 5, 0.99);

        double cartTotal = shoppingCart.calculateTotalCart();

        Assertions.assertEquals(4.95, cartTotal);

    }

    @Test
    void givenEmptyShoppingCart_whenAddOneMask_thenShouldReturnTotalCartPriceOnrPointNineNine() {
        ShoppingCart shoppingCart = new ShoppingCart("mask", 1, 1.99);

        double cartTotal = shoppingCart.calculateTotalCart();

        Assertions.assertEquals(1.99, cartTotal);

    }
    @Test
    void givenEmptyShoppingCart_whenAddThreeMaskAndThreeApple_thenShouldReturnTotalCartPriceTwoPointNineEight() {
        Product productOne=new Product("apple",1,0.99);
        Product productTwo=new Product("mask",1,1.99);

        ArrayList<Product> products=new ArrayList<Product>();
        products.add(productOne);
        products.add(productTwo);

        ShoppingCart shoppingCart=new ShoppingCart(products);
        double cartTotal = shoppingCart.calculateTotalCart();

        Assertions.assertEquals(2.98, cartTotal);

    }
}
