package com.thoughtworks.bootcamp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
}
