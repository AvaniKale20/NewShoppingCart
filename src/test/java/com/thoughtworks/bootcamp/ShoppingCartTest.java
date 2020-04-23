package com.thoughtworks.bootcamp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartTest {
    @Test
    void givenEmptyShoppingCart_whenAddOneApple_thenShouldReturnTotalCartPriceZeroPointNineNine() {
        Product productOne = new Product("apple", 1, 0.99);
        ArrayList<Product> products = new ArrayList<>();
        products.add(productOne);

        ShoppingCart shoppingCart = new ShoppingCart(products);

        List<Double> cartTotal = shoppingCart.calculateTotalCart();

        Assertions.assertEquals(0.02, cartTotal.get(0));
        Assertions.assertEquals(1.01, cartTotal.get(1));

    }

    @Test
    void givenEmptyShoppingCart_whenAddFiveApple_thenShouldReturnTotalCartPriceZeroPointNineNine() {
        Product productOne = new Product("apple", 5, 0.99);
        ArrayList<Product> products = new ArrayList<>();
        products.add(productOne);

        ShoppingCart shoppingCart = new ShoppingCart(products);

        List<Double> cartTotal = shoppingCart.calculateTotalCart();

        Assertions.assertEquals(0.1, cartTotal.get(0));
        Assertions.assertEquals(5.05, cartTotal.get(1));

    }

    @Test
    void givenEmptyShoppingCart_whenAddOneMask_thenShouldReturnTotalCartPriceOnrPointNineNine() {
        Product productOne = new Product("mask", 1, 1.99);
        ArrayList<Product> products = new ArrayList<>();
        products.add(productOne);

        ShoppingCart shoppingCart = new ShoppingCart(products);

        List<Double> cartTotal = shoppingCart.calculateTotalCart();

        Assertions.assertEquals(0.04, cartTotal.get(0));
        Assertions.assertEquals(2.03, cartTotal.get(1));

    }

    @Test
    void givenEmptyShoppingCart_whenAddOneMaskAndOneApple_thenShouldReturnTotalCartPriceTwoPointNineEight() {
        Product productOne = new Product("apple", 1, 0.99);
        Product productTwo = new Product("mask", 1, 1.99);

        ArrayList<Product> products = new ArrayList<Product>();
        products.add(productOne);
        products.add(productTwo);

        ShoppingCart shoppingCart = new ShoppingCart(products);

        List<Double> totalCart = shoppingCart.calculateTotalCart();

        Assertions.assertEquals(0.06, totalCart.get(0));
        Assertions.assertEquals(3.04, totalCart.get(1));

    }

    @Test
    void givenEmptyShoppingCart_whenAddThreeMaskAndThreeApple_thenShouldReturnTotalCartPriceEightPointNineFour() {
        Product productOne = new Product("apple", 3, 0.99);
        Product productTwo = new Product("mask", 3, 1.99);

        ArrayList<Product> products = new ArrayList<Product>();
        products.add(productOne);
        products.add(productTwo);

        ShoppingCart shoppingCart = new ShoppingCart(products);
        List<Double> cartTotal = shoppingCart.calculateTotalCart();

        Assertions.assertEquals(0.18, cartTotal.get(0));
        Assertions.assertEquals(9.12, cartTotal.get(1));

    }

    @Test
    void givenEmptyShoppingCart_whenAddThreeMaskAndThreeApple_thenShouldReturnTotalCartPriceWithTax() {
        Product productOne = new Product("apple", 3, 0.99);
        Product productTwo = new Product("mask", 3, 1.99);

        ArrayList<Product> products = new ArrayList<>();
        products.add(productOne);
        products.add(productTwo);

        ShoppingCart shoppingCart = new ShoppingCart(products);

        List<Double> cartTotal = shoppingCart.calculateTotalCart();
        Assertions.assertEquals(0.18, cartTotal.get(0));
        Assertions.assertEquals(9.12, cartTotal.get(1));

    }

}
