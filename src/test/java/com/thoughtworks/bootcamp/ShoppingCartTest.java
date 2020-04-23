package com.thoughtworks.bootcamp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ShoppingCartTest {
    @Test
    void givenEmptyShoppingCart_whenAddOneApple_thenShouldReturnTotalCartPriceZeroPointNineNine() {
        Product apple = new Product("apples", 0.99);
        ArrayList<Product> products = new ArrayList<>();
        products.add(apple);

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addCart(apple, 1);

        Assertions.assertEquals(0.02, shoppingCart.getSalesTax());
        Assertions.assertEquals(1.01, shoppingCart.getTotalCartWithTax());
        Assertions.assertEquals(1, shoppingCart.getQuantity("apples"));
        Assertions.assertEquals("cart contains 1 apples of 0.99 each", shoppingCart.getContent(products));

    }

    @Test
    void givenEmptyShoppingCart_whenAddFiveApple_thenShouldReturnTotalCartPriceZeroPointNineNine() {
        Product apple = new Product("apples", 0.99);
        ArrayList<Product> products = new ArrayList<>();
        products.add(apple);

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addCart(apple, 5);

        Assertions.assertEquals(0.1, shoppingCart.getSalesTax());
        Assertions.assertEquals(5.05, shoppingCart.getTotalCartWithTax());
        Assertions.assertEquals(5, shoppingCart.getQuantity("apples"));
        Assertions.assertEquals("cart contains 5 apples of 0.99 each", shoppingCart.getContent(products));
    }

    @Test
    void givenEmptyShoppingCart_whenAddOneMask_thenShouldReturnTotalCartPriceOnrPointNineNine() {
        Product mask = new Product("mask", 1.99);
        ArrayList<Product> products = new ArrayList<>();
        products.add(mask);

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addCart(mask, 1);


        Assertions.assertEquals(0.04, shoppingCart.getSalesTax());
        Assertions.assertEquals(2.03, shoppingCart.getTotalCartWithTax());
        Assertions.assertEquals(1, shoppingCart.getQuantity("mask"));
        Assertions.assertEquals("cart contains 1 mask of 1.99 each", shoppingCart.getContent(products));

    }

    //
    @Test
    void givenEmptyShoppingCart_whenAddOneMaskAndOneApple_thenShouldReturnTotalCartPriceTwoPointNineEight() {
        Product apple = new Product("apple", 0.99);
        Product mask = new Product("mask", 1.99);
        ArrayList<Product> products = new ArrayList<>();
        products.add(apple);
        products.add(mask);

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addCart(apple, 1);
        shoppingCart.addCart(mask, 1);

        Assertions.assertEquals(0.06, shoppingCart.getSalesTax());
        Assertions.assertEquals(3.04, shoppingCart.getTotalCartWithTax());
        Assertions.assertEquals(1, shoppingCart.getQuantity("mask"));
        Assertions.assertEquals(1, shoppingCart.getQuantity("apple"));
        Assertions.assertEquals("cart contains 1 apple of 0.99 each", shoppingCart.getContent(products));
//        Assertions.assertEquals("cart contains 1 mask of 1.99 each",shoppingCart.getContent(products));

    }

    @Test
    void givenEmptyShoppingCart_whenAddThreeMaskAndThreeApple_thenShouldReturnTotalCartPriceEightPointNineFour() {
        Product apple = new Product("apple", 0.99);
        Product mask = new Product("mask", 1.99);
        ArrayList<Product> products = new ArrayList<>();
        products.add(apple);
        products.add(mask);

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addCart(apple, 3);
        shoppingCart.addCart(mask, 3);

        Assertions.assertEquals(0.18, shoppingCart.getSalesTax());
        Assertions.assertEquals(9.12, shoppingCart.getTotalCartWithTax());
        Assertions.assertEquals(3, shoppingCart.getQuantity("mask"));
        Assertions.assertEquals(3, shoppingCart.getQuantity("apple"));
        Assertions.assertEquals("cart contains 3 apple of 0.99 each", shoppingCart.getContent(products));
//        Assertions.assertEquals("cart contains 3 mask of 1.99 each",shoppingCart.getContent(products));

    }

    @Test
    void givenEmptyShoppingCart_whenAddThreeMaskAndThreeApple_thenShouldReturnTotalCartPriceWithTax() {
        Product apple = new Product("apple", 0.99);
        Product mask = new Product("mask", 1.99);
        ArrayList<Product> products = new ArrayList<>();
        products.add(apple);
        products.add(mask);

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addCart(apple, 2);
        shoppingCart.addCart(apple, 1);
        shoppingCart.addCart(mask, 3);

        Assertions.assertEquals(0.18, shoppingCart.getSalesTax());
        Assertions.assertEquals(9.12, shoppingCart.getTotalCartWithTax());
        Assertions.assertEquals(3, shoppingCart.getQuantity("mask"));
        Assertions.assertEquals(3, shoppingCart.getQuantity("apple"));
        Assertions.assertEquals("cart contains 3 apple of 0.99 each", shoppingCart.getContent(products));
//        Assertions.assertEquals("cart contains 3 mask of 1.99 each",shoppingCart.getContent(products));

    }

    @Test
    void givenEmptyShoppingCart_whenAddSixAppleThreeMask_thenShouldReturnTotalCartPriceWithTax() {
        Product apple = new Product("apple", 0.99);
        Product mask = new Product("mask", 1.99);
        ArrayList<Product> products = new ArrayList<>();
        products.add(apple);
        products.add(mask);

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addCart(apple, 5);
        shoppingCart.addCart(apple, 1);
        shoppingCart.addCart(mask, 3);

        Assertions.assertEquals(0.24, shoppingCart.getSalesTax());
        Assertions.assertEquals(12.15, shoppingCart.getTotalCartWithTax());
        Assertions.assertEquals(3, shoppingCart.getQuantity("mask"));
        Assertions.assertEquals(6, shoppingCart.getQuantity("apple"));
        Assertions.assertEquals("cart contains 6 apple of 0.99 each", shoppingCart.getContent(products));
//        Assertions.assertEquals("cart contains 3 mask of 1.99 each",shoppingCart.getContent());

    }


}
