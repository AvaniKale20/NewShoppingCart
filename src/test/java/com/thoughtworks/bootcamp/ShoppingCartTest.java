package com.thoughtworks.bootcamp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ShoppingCartTest {
    @Test
    void givenEmptyShoppingCart_whenAddOneApple_thenShouldReturnTotalCartPriceZeroPointNineNine() {
        Product apple = new Product("Apple", 0.99);
        ArrayList<Product> products = new ArrayList<>();
        products.add(apple);

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addCart(apple, 1);

        Assertions.assertEquals(0.02, shoppingCart.getSalesTax());
        Assertions.assertEquals(1.01, shoppingCart.getTotalCartWithTax());
        Assertions.assertEquals(1, shoppingCart.getQuantity("Apple"));
        Assertions.assertEquals(" the cart contains 1 Apple of 0.99 each ", shoppingCart.getContent(products));

    }

    @Test
    void givenEmptyShoppingCart_whenAddFiveApple_thenShouldReturnTotalCartPriceZeroPointNineNine() {
        Product apple = new Product("Apple", 0.99);
        ArrayList<Product> products = new ArrayList<>();
        products.add(apple);

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addCart(apple, 5);

        Assertions.assertEquals(0.1, shoppingCart.getSalesTax());
        Assertions.assertEquals(5.05, shoppingCart.getTotalCartWithTax());
        Assertions.assertEquals(5, shoppingCart.getQuantity("Apple"));
        Assertions.assertEquals(" the cart contains 5 Apple of 0.99 each ", shoppingCart.getContent(products));
    }

    @Test
    void givenEmptyShoppingCart_whenAddOneMask_thenShouldReturnTotalCartPriceOnrPointNineNine() {
        Product mask = new Product("Mask", 1.99);
        ArrayList<Product> products = new ArrayList<>();
        products.add(mask);

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addCart(mask, 1);


        Assertions.assertEquals(0.04, shoppingCart.getSalesTax());
        Assertions.assertEquals(2.03, shoppingCart.getTotalCartWithTax());
        Assertions.assertEquals(1, shoppingCart.getQuantity("Mask"));
        Assertions.assertEquals(" the cart contains 1 Mask of 1.99 each ", shoppingCart.getContent(products));

    }

    //
    @Test
    void givenEmptyShoppingCart_whenAddOneMaskAndOneApple_thenShouldReturnTotalCartPriceTwoPointNineEight() {
        Product apple = new Product("Apple", 0.99);
        Product mask = new Product("Mask", 1.99);
        ArrayList<Product> products = new ArrayList<>();
        products.add(apple);
        products.add(mask);

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addCart(apple, 1);
        shoppingCart.addCart(mask, 1);

        Assertions.assertEquals(0.06, shoppingCart.getSalesTax());
        Assertions.assertEquals(3.04, shoppingCart.getTotalCartWithTax());
        Assertions.assertEquals(1, shoppingCart.getQuantity("Mask"));
        Assertions.assertEquals(1, shoppingCart.getQuantity("Apple"));
        Assertions.assertEquals("The cart contains 1 Apple of 0.99 each and 1 Mask of 1.99 each", shoppingCart.getContent(products));

    }

    @Test
    void givenEmptyShoppingCart_whenAddThreeMaskAndThreeApple_thenShouldReturnTotalCartPriceEightPointNineFour() {
        Product apple = new Product("Apple", 0.99);
        Product mask = new Product("Mask", 1.99);
        ArrayList<Product> products = new ArrayList<>();
        products.add(apple);
        products.add(mask);

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addCart(apple, 3);
        shoppingCart.addCart(mask, 3);

        Assertions.assertEquals(0.18, shoppingCart.getSalesTax());
        Assertions.assertEquals(9.12, shoppingCart.getTotalCartWithTax());
        Assertions.assertEquals(3, shoppingCart.getQuantity("Mask"));
        Assertions.assertEquals(3, shoppingCart.getQuantity("Apple"));
        Assertions.assertEquals("The cart contains 3 Apple of 0.99 each and 3 Mask of 1.99 each", shoppingCart.getContent(products));

    }

    @Test
    void givenEmptyShoppingCart_whenAddThreeMaskAndThreeApple_thenShouldReturnTotalCartPriceWithTax() {
        Product apple = new Product("Apple", 0.99);
        Product mask = new Product("Mask", 1.99);
        ArrayList<Product> products = new ArrayList<>();
        products.add(apple);
        products.add(mask);

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addCart(apple, 2);
        shoppingCart.addCart(apple, 1);
        shoppingCart.addCart(mask, 3);

        Assertions.assertEquals(0.18, shoppingCart.getSalesTax());
        Assertions.assertEquals(9.12, shoppingCart.getTotalCartWithTax());
        Assertions.assertEquals(3, shoppingCart.getQuantity("Mask"));
        Assertions.assertEquals(3, shoppingCart.getQuantity("Apple"));
        Assertions.assertEquals("The cart contains 3 Apple of 0.99 each and 3 Mask of 1.99 each", shoppingCart.getContent(products));

    }

    @Test
    void givenEmptyShoppingCart_whenAddSixAppleThreeMask_thenShouldReturnTotalCartPriceWithTax() {
        Product apple = new Product("Apple", 0.99);
        Product mask = new Product("Mask", 1.99);
        ArrayList<Product> products = new ArrayList<>();
        products.add(apple);
        products.add(mask);

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addCart(apple, 5);
        shoppingCart.addCart(apple, 1);
        shoppingCart.addCart(mask, 3);

        Assertions.assertEquals(0.24, shoppingCart.getSalesTax());
        Assertions.assertEquals(12.15, shoppingCart.getTotalCartWithTax());
        Assertions.assertEquals(3, shoppingCart.getQuantity("Mask"));
        Assertions.assertEquals(6, shoppingCart.getQuantity("Apple"));
        Assertions.assertEquals("The cart contains 6 Apple of 0.99 each and 3 Mask of 1.99 each", shoppingCart.getContent(products));

    }

//    @Test
//    void givenEmptyShoppingCart_whenAddTwoAppleWithBuyTwoGetOneFreeOffer_thenShouldReturnTotalCartPriceOfTwoApplesWithTax() {
//        Product apple = new Product("apple", 0.99);//no
//        ArrayList<Product> products = new ArrayList<>();
//        products.add(apple);
//
//        ShoppingCart shoppingCart = new ShoppingCart();//no
//        shoppingCart.addCart(apple, 2);
//
//        Assertions.assertEquals(0.04, shoppingCart.getSalesTax());
//        Assertions.assertEquals(2.02, shoppingCart.getTotalCartWithTax());
//        Assertions.assertEquals(3, shoppingCart.getQuantity("apple"));
//
//    }
//    @Test
//    void givenEmptyShoppingCart_whenAddFiveAppleWithBuyTwoGetOneFreeOffer_thenShouldReturnTotalCartPriceOfFourApplesWithTax() {
//        Product apple = new Product("apple", 0.99);//no
//        ArrayList<Product> products = new ArrayList<>();
//        products.add(apple);
//
//        ShoppingCart shoppingCart = new ShoppingCart();//no
//        shoppingCart.addCart(apple, 5);
//
////        Assertions.assertEquals(0.04, shoppingCart.getSalesTax());
////        Assertions.assertEquals(2.02, shoppingCart.getTotalCartWithTax());
//        Assertions.assertEquals(6, shoppingCart.getQuantity("apple"));
//
//    }

}
