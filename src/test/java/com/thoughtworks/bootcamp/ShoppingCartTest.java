package com.thoughtworks.bootcamp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShoppingCartTest {
    @Test
    void givenEmptyShoppingCart_whenAddOneApple_thenShouldReturnTotalCartPriceZeroPointNineNine() {
        BuyXGetYFree buy2Get1 = new BuyXGetYFree(2, 1);
        Product apple = new Product("Apple", 0.99, buy2Get1);

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addCart(apple, 1);

        Assertions.assertEquals(0.02, shoppingCart.getSalesTax());
        Assertions.assertEquals(1.01, shoppingCart.getTotalCartWithTax());
        Assertions.assertEquals("ShoppingCart{cartItems=[CartItem{product=Product{name='Apple', price=0.99}, quantity=1}]}", shoppingCart.toString());
        Assertions.assertEquals(0.0, shoppingCart.ShoppingCartDiscount());

    }


    @Test
    void givenEmptyShoppingCart_whenAddFiveApple_thenShouldReturnTotalCartPriceZeroPointNineNine() {
        BuyXGetYFree buy2Get1 = new BuyXGetYFree(2, 1);
        Product apple = new Product("Apple", 0.99, buy2Get1);

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addCart(apple, 5);

        Assertions.assertEquals(0.08, shoppingCart.getSalesTax());
        Assertions.assertEquals(4.04, shoppingCart.getTotalCartWithTax());
        Assertions.assertEquals("ShoppingCart{cartItems=[CartItem{product=Product{name='Apple', price=0.99}, quantity=5}]}", shoppingCart.toString());
        Assertions.assertEquals(0.99, shoppingCart.ShoppingCartDiscount());
    }


    @Test
    void givenEmptyShoppingCart_whenAddOneMask_thenShouldReturnTotalCartPriceOnrPointNineNine() {

        Product mask = new Product("Mask", 1.99);

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addCart(mask, 1);


        Assertions.assertEquals(0.04, shoppingCart.getSalesTax());
        Assertions.assertEquals(2.03, shoppingCart.getTotalCartWithTax());
        Assertions.assertEquals("ShoppingCart{cartItems=[CartItem{product=Product{name='Mask', price=1.99}, quantity=1}]}", shoppingCart.toString());

    }

    @Test
    void givenEmptyShoppingCart_whenAddOneMaskAndOneApple_thenShouldReturnTotalCartPriceTwoPointNineEight() {
        BuyXGetYFree buy2Get1 = new BuyXGetYFree(2, 1);
        Product apple = new Product("Apple", 0.99, buy2Get1);
        Product mask = new Product("Mask", 1.99);

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addCart(apple, 1);
        shoppingCart.addCart(mask, 1);

        Assertions.assertEquals(0.06, shoppingCart.getSalesTax());
        Assertions.assertEquals(3.04, shoppingCart.getTotalCartWithTax());

        Assertions.assertEquals("ShoppingCart{cartItems=[CartItem{product=Product{name='Apple', price=0.99}, quantity=1}," +
                " CartItem{product=Product{name='Mask', price=1.99}, quantity=1}]}", shoppingCart.toString());
    }

    @Test
    void givenEmptyShoppingCart_whenAddThreeMaskAndThreeApple_thenShouldReturnTotalCartPriceEightPointNineFour() {
        BuyXGetYFree buy2Get1 = new BuyXGetYFree(2, 1);
        Product apple = new Product("Apple", 0.99, buy2Get1);
        Product mask = new Product("Mask", 1.99);

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addCart(apple, 3);
        shoppingCart.addCart(mask, 3);
        Assertions.assertEquals(0.16, shoppingCart.getSalesTax());
        Assertions.assertEquals(8.11, shoppingCart.getTotalCartWithTax());

        Assertions.assertEquals("ShoppingCart{cartItems=[CartItem{product=Product{name='Apple', price=0.99}, quantity=3}, " +
                "CartItem{product=Product{name='Mask', price=1.99}, quantity=3}]}", shoppingCart.toString());
        Assertions.assertEquals(0.99, shoppingCart.ShoppingCartDiscount());

    }


    @Test
    void givenEmptyShoppingCart_whenAddThreeMaskAndThreeApple_thenShouldReturnTotalCartPriceWithTax() {
        BuyXGetYFree buy2Get1 = new BuyXGetYFree(2, 1);
        Product apple = new Product("Apple", 0.99, buy2Get1);
        Product mask = new Product("Mask", 1.99);

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addCart(apple, 2);
        shoppingCart.addCart(apple, 1);
        shoppingCart.addCart(mask, 3);

        Assertions.assertEquals(0.16, shoppingCart.getSalesTax());
        Assertions.assertEquals(8.11, shoppingCart.getTotalCartWithTax());
        Assertions.assertEquals("ShoppingCart{cartItems=[CartItem{product=Product{name='Apple', price=0.99}, quantity=3}," +
                " CartItem{product=Product{name='Mask', price=1.99}, quantity=3}]}", shoppingCart.toString());
        Assertions.assertEquals(0.99, shoppingCart.ShoppingCartDiscount());


    }

    @Test
    void givenEmptyShoppingCart_whenAddSixAppleThreeMask_thenShouldReturnTotalCartPriceWithTax() {
        BuyXGetYFree buy2Get1 = new BuyXGetYFree(2, 1);
        TenPercentPriceOffer tenPercentPriceOffer=new TenPercentPriceOffer(10.0,10);

        Product apple = new Product("Apple", 0.99, buy2Get1);
        Product mask = new Product("Mask", 1.99);

        ShoppingCart shoppingCart = new ShoppingCart(tenPercentPriceOffer);
        shoppingCart.addCart(apple, 5);
        shoppingCart.addCart(apple, 1);
        shoppingCart.addCart(mask, 3);

        Assertions.assertEquals(0.2, shoppingCart.getSalesTax());
        Assertions.assertEquals(10.13, shoppingCart.getTotalCartWithTax());

        Assertions.assertEquals("ShoppingCart{cartItems=[CartItem{product=Product{name='Apple', price=0.99}, quantity=6}," +
                " CartItem{product=Product{name='Mask', price=1.99}, quantity=3}]}", shoppingCart.toString());
        Assertions.assertEquals(1.98, shoppingCart.ShoppingCartDiscount());

    }

        @Test
    void givenEmptyShoppingCart_whenAddThreeAppleWithBuyMoreThanTwoGetOneFreeOffer_thenShouldReturnTotalThreeAppleAndOneFreeApple() {
        BuyXGetYFree buy2Get1 = new BuyXGetYFree(2, 1);

        Product apple = new Product("Apple", 0.99, buy2Get1);

        ShoppingCart shoppingCart = new ShoppingCart();

        shoppingCart.addCart(apple, 3);

        Assertions.assertEquals(0.04, shoppingCart.getSalesTax());
        Assertions.assertEquals(2.02, shoppingCart.getTotalCartWithTax());
        Assertions.assertEquals("ShoppingCart{cartItems=[CartItem{product=Product{name='Apple', price=0.99}, quantity=3}]}", shoppingCart.toString());
        Assertions.assertEquals(0.99, shoppingCart.ShoppingCartDiscount());
    }

    @Test
    void givenEmptyShoppingCart_whenAddOneAppleWithBuyMoreThanTwoGetOneFreeOffer_thenShouldReturnTotalThreeAppleAndZeroFreeApple() {
        BuyXGetYFree buy2Get1 = new BuyXGetYFree(2, 1);

        Product apple = new Product("Apple", 0.99, buy2Get1);

        ShoppingCart shoppingCart = new ShoppingCart();

        shoppingCart.addCart(apple, 1);

        Assertions.assertEquals(0.02, shoppingCart.getSalesTax());
        Assertions.assertEquals(1.01, shoppingCart.getTotalCartWithTax());
        Assertions.assertEquals("ShoppingCart{cartItems=[CartItem{product=Product{name='Apple', price=0.99}, quantity=1}]}", shoppingCart.toString());
        Assertions.assertEquals(0.0, shoppingCart.ShoppingCartDiscount());
    }

    @Test
    void givenEmptyShoppingCart_whenAddTwoAppleWithBuyMoreThanTwoGetOneFreeOffer_thenShouldReturnTotalTwoAppleAndZeroFreeApple() {
        BuyXGetYFree buy2Get1 = new BuyXGetYFree(2, 1);

        Product apple = new Product("Apple", 0.99, buy2Get1);

        ShoppingCart shoppingCart = new ShoppingCart();

        shoppingCart.addCart(apple, 1);
        shoppingCart.addCart(apple, 1);

        Assertions.assertEquals(0.04, shoppingCart.getSalesTax());
        Assertions.assertEquals(2.02, shoppingCart.getTotalCartWithTax());
        Assertions.assertEquals("ShoppingCart{cartItems=[CartItem{product=Product{name='Apple', price=0.99}, quantity=2}]}", shoppingCart.toString());
        Assertions.assertEquals(0.0, shoppingCart.ShoppingCartDiscount());
    }

    @Test
    void givenEmptyShoppingCart_whenAddFiveAppleWithBuyMoreThanTwoGetOneFreeOffer_thenShouldReturnTotalFiveAppleAndOneApple() {
        BuyXGetYFree buy2Get1 = new BuyXGetYFree(2, 1);

        Product apple = new Product("Apple", 0.99, buy2Get1);

        ShoppingCart shoppingCart = new ShoppingCart();

        shoppingCart.addCart(apple, 2);
        shoppingCart.addCart(apple, 2);
        shoppingCart.addCart(apple, 1);

        Assertions.assertEquals(0.08, shoppingCart.getSalesTax());
        Assertions.assertEquals(4.04, shoppingCart.getTotalCartWithTax());
        Assertions.assertEquals("ShoppingCart{cartItems=[CartItem{product=Product{name='Apple', price=0.99}, quantity=5}]}", shoppingCart.toString());
        Assertions.assertEquals(0.99, shoppingCart.ShoppingCartDiscount());
    }

    @Test
    void givenEmptyShoppingCart_whenAddFiveAppleWithBuyMoreThanTwoGetOneFreeOffer_And_OneMaskWithNoOffer_thenShouldReturnTotalThreeAppleAndOneMaskAndOneAppleFree() {
        BuyXGetYFree buy2Get1 = new BuyXGetYFree(2, 1);
        Product apple = new Product("Apple", 0.99, buy2Get1);
        Product mask = new Product("Mask", 1.99);

        ShoppingCart shoppingCart = new ShoppingCart();

        shoppingCart.addCart(apple, 5);
        shoppingCart.addCart(mask, 1);

        Assertions.assertEquals(0.12, shoppingCart.getSalesTax());
        Assertions.assertEquals(6.07, shoppingCart.getTotalCartWithTax());
        Assertions.assertEquals("ShoppingCart{cartItems=[CartItem{product=Product{name='Apple', price=0.99}, quantity=5}, CartItem{product=Product{name='Mask', price=1.99}, quantity=1}]}", shoppingCart.toString());
        Assertions.assertEquals(0.99, shoppingCart.ShoppingCartDiscount());
    }

    @Test
    void givenEmptyShoppingCart_whenAddThreeAppleWithBuyMoreThanTwoGetOneFreeOffer_thenShouldReturnDiscountOfOneApple() {
        BuyXGetYFree buy2Get1 = new BuyXGetYFree(2, 1);

        Product apple = new Product("Apple", 0.99, buy2Get1);

        ShoppingCart shoppingCart = new ShoppingCart();

        shoppingCart.addCart(apple, 1);
        shoppingCart.addCart(apple, 1);
        shoppingCart.addCart(apple, 1);

        Assertions.assertEquals(0.04, shoppingCart.getSalesTax());
        Assertions.assertEquals(2.02, shoppingCart.getTotalCartWithTax());
        Assertions.assertEquals("ShoppingCart{cartItems=[CartItem{product=Product{name='Apple', price=0.99}, quantity=3}]}", shoppingCart.toString());
        Assertions.assertEquals(0.99, shoppingCart.ShoppingCartDiscount());
    }

    @Test
    void givenEmptyShoppingCart_whenAddMoreThanTenAppleWithTenPercentOff_thenShouldReturnDiscountOfMoreThanOneApple() {
        BuyXGetYFree buy2Get1 = new BuyXGetYFree(2, 1);
        TenPercentPriceOffer tenPercentPriceOffer = new TenPercentPriceOffer(10.00, 10);

        Product apple = new Product("Apple", 0.99, buy2Get1);

        ShoppingCart shoppingCart = new ShoppingCart(tenPercentPriceOffer);

        shoppingCart.addCart(apple, 10);

        Assertions.assertEquals(0.14, shoppingCart.getSalesTax());
        Assertions.assertEquals(7.07, shoppingCart.getTotalCartWithTax());
        Assertions.assertEquals("ShoppingCart{cartItems=[CartItem{product=Product{name='Apple', price=0.99}, quantity=10}]}", shoppingCart.toString());
        Assertions.assertEquals(2.97, shoppingCart.ShoppingCartDiscount());

    }
    @Test
    void givenEmptyShoppingCart_whenAddTenAppleAndThreeMaskWithTenPercentOff_thenShouldReturnDiscountWithTenPercent
    () {
        BuyXGetYFree buy2Get1 = new BuyXGetYFree(2, 1);
        TenPercentPriceOffer tenPercentPriceOffer = new TenPercentPriceOffer(10.00, 10);

        Product apple = new Product("Apple", 0.99, buy2Get1);
        Product mask = new Product("Mask", 1.99);//null

        ShoppingCart shoppingCart = new ShoppingCart(tenPercentPriceOffer);

        shoppingCart.addCart(apple, 10);
        shoppingCart.addCart(mask, 3);


        Assertions.assertEquals(0.23, shoppingCart.getSalesTax());
        Assertions.assertEquals(11.84, shoppingCart.getTotalCartWithTax());//11.61+0.23=11.84
        Assertions.assertEquals("ShoppingCart{cartItems=[CartItem{product=Product{name='Apple', price=0.99}, quantity=10}, CartItem{product=Product{name='Mask', price=1.99}, quantity=3}]}", shoppingCart.toString());
        Assertions.assertEquals(4.26, shoppingCart.ShoppingCartDiscount());


    }


}
