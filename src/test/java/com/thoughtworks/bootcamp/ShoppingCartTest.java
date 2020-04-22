package com.thoughtworks.bootcamp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ShoppingCartTest {
    @Test
    void givenEmptyShoppingCart_whenAddOneApple_thenShouldReturnTotalCartPriceZeroPointNineNine() {
        Product productOne = new Product("apple", 1, 0.99);
        ArrayList<Product> products = new ArrayList<>();
        products.add(productOne);

        ShoppingCart shoppingCart = new ShoppingCart(products);

        double cartTotal = shoppingCart.calculateTotalCart();

        Assertions.assertEquals(1.01, cartTotal);

    }

    @Test
    void givenEmptyShoppingCart_whenAddFiveApple_thenShouldReturnTotalCartPriceZeroPointNineNine() {
        Product productOne = new Product("apple", 5, 0.99);
        ArrayList<Product> products = new ArrayList<>();
        products.add(productOne);

        ShoppingCart shoppingCart = new ShoppingCart(products);

        double cartTotal = shoppingCart.calculateTotalCart();

        Assertions.assertEquals(5.05, cartTotal);

    }

    @Test
    void givenEmptyShoppingCart_whenAddOneMask_thenShouldReturnTotalCartPriceOnrPointNineNine() {
        Product productOne = new Product("mask", 1, 1.99);
        ArrayList<Product> products = new ArrayList<>();
        products.add(productOne);

        ShoppingCart shoppingCart = new ShoppingCart(products);

        double cartTotal = shoppingCart.calculateTotalCart();

        Assertions.assertEquals(2.03, cartTotal);

    }

    @Test
    void givenEmptyShoppingCart_whenAddOneMaskAndOneApple_thenShouldReturnTotalCartPriceTwoPointNineEight() {
        Product productOne = new Product("apple", 1, 0.99);
        Product productTwo = new Product("mask", 1, 1.99);

        ArrayList<Product> products = new ArrayList<Product>();
        products.add(productOne);
        products.add(productTwo);

        ShoppingCart shoppingCart = new ShoppingCart(products);
        double cartTotal = shoppingCart.calculateTotalCart();

        Assertions.assertEquals(3.04, cartTotal);

    }
    @Test
    void givenEmptyShoppingCart_whenAddThreeMaskAndThreeApple_thenShouldReturnTotalCartPriceEightPointNineFour() {
        Product productOne = new Product("apple", 3, 0.99);
        Product productTwo = new Product("mask", 3, 1.99);

        ArrayList<Product> products = new ArrayList<Product>();
        products.add(productOne);
        products.add(productTwo);

        ShoppingCart shoppingCart = new ShoppingCart(products);
        double cartTotal = shoppingCart.calculateTotalCart();

        Assertions.assertEquals(9.12, cartTotal);

    }
    @Test
    void givenEmptyShoppingCart_whenAddThreeMaskAndThreeApple_thenShouldReturnTotalCartPriceWithTax() {
        Product productOne = new Product("apple", 3, 0.99);
        Product productTwo = new Product("mask", 3, 1.99);

        ArrayList<Product> products = new ArrayList<>();
        products.add(productOne);
        products.add(productTwo);

        ShoppingCart shoppingCart = new ShoppingCart(products);
        double cartTotal = shoppingCart.calculateTotalCart();

        Assertions.assertEquals(9.12, cartTotal);

    }

}
