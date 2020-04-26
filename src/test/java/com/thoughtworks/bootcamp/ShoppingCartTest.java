package com.thoughtworks.bootcamp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShoppingCartTest {
    @Test
    void givenEmptyShoppingCart_whenAddOneApple_thenShouldReturnTotalCartPriceZeroPointNineNine() {
        Offers buy2Get1 = new Offers(2, 1);
        Product apple = new Product("Apple", 0.99, buy2Get1);

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addCart(apple, 1);

        Assertions.assertEquals(0.02, shoppingCart.getSalesTax());
        Assertions.assertEquals(1.01, shoppingCart.getTotalCartWithTax());
        Assertions.assertEquals("ShoppingCart{cartItems=[CartItem{product=Product{name='Apple', price=0.99}, quantity=1}]}", shoppingCart.toString());
        Assertions.assertEquals(0, shoppingCart.getFreeProduct(apple));
        Assertions.assertEquals(0.0, shoppingCart.getDiscount(apple));

    }

    @Test
    void givenEmptyShoppingCart_whenAddFiveApple_thenShouldReturnTotalCartPriceZeroPointNineNine() {
        Offers buy2Get1 = new Offers(2, 1);
        Product apple = new Product("Apple", 0.99, buy2Get1);

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addCart(apple, 5);

        Assertions.assertEquals(0.1, shoppingCart.getSalesTax());
        Assertions.assertEquals(5.05, shoppingCart.getTotalCartWithTax());
        Assertions.assertEquals("ShoppingCart{cartItems=[CartItem{product=Product{name='Apple', price=0.99}, quantity=5}]}", shoppingCart.toString());
        Assertions.assertEquals(1, shoppingCart.getFreeProduct(apple));
        Assertions.assertEquals(0.99, shoppingCart.getDiscount(apple));
    }


    @Test
    void givenEmptyShoppingCart_whenAddOneMask_thenShouldReturnTotalCartPriceOnrPointNineNine() {

        Offers noOffer = new Offers(0, 0);
        Product mask = new Product("Mask", 1.99, noOffer);

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addCart(mask, 1);


        Assertions.assertEquals(0.04, shoppingCart.getSalesTax());
        Assertions.assertEquals(2.03, shoppingCart.getTotalCartWithTax());
        Assertions.assertEquals("ShoppingCart{cartItems=[CartItem{product=Product{name='Mask', price=1.99}, quantity=1}]}", shoppingCart.toString());

    }

    @Test
    void givenEmptyShoppingCart_whenAddOneMaskAndOneApple_thenShouldReturnTotalCartPriceTwoPointNineEight() {
        Offers buy2Get1 = new Offers(2, 1);
        Offers noOffer = new Offers(0, 0);
        Product apple = new Product("Apple", 0.99, buy2Get1);
        Product mask = new Product("Mask", 1.99, noOffer);

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addCart(apple, 1);
        shoppingCart.addCart(mask, 1);

        Assertions.assertEquals(0.06, shoppingCart.getSalesTax());
        Assertions.assertEquals(3.04, shoppingCart.getTotalCartWithTax());

        Assertions.assertEquals("ShoppingCart{cartItems=[CartItem{product=Product{name='Apple', price=0.99}, quantity=1}," +
                " CartItem{product=Product{name='Mask', price=1.99}, quantity=1}]}", shoppingCart.toString());
        Assertions.assertEquals(0, shoppingCart.getFreeProduct(apple));
        Assertions.assertEquals(0.0, shoppingCart.getDiscount(apple));

    }

    @Test
    void givenEmptyShoppingCart_whenAddThreeMaskAndThreeApple_thenShouldReturnTotalCartPriceEightPointNineFour() {
        Offers buy2Get1 = new Offers(2, 1);
        Offers noOffer = new Offers(0, 0);
        Product apple = new Product("Apple", 0.99, buy2Get1);
        Product mask = new Product("Mask", 1.99, noOffer);

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addCart(apple, 3);
        shoppingCart.addCart(mask, 3);

        Assertions.assertEquals(0.18, shoppingCart.getSalesTax());
        Assertions.assertEquals(9.12, shoppingCart.getTotalCartWithTax());

        Assertions.assertEquals("ShoppingCart{cartItems=[CartItem{product=Product{name='Apple', price=0.99}, quantity=3}, " +
                "CartItem{product=Product{name='Mask', price=1.99}, quantity=3}]}", shoppingCart.toString());
        Assertions.assertEquals(1, shoppingCart.getFreeProduct(apple));
        Assertions.assertEquals(0.99, shoppingCart.getDiscount(apple));

    }

    @Test
    void givenEmptyShoppingCart_whenAddThreeMaskAndThreeApple_thenShouldReturnTotalCartPriceWithTax() {
        Offers buy2Get1 = new Offers(2, 1);
        Offers noOffer = new Offers(0, 0);
        Product apple = new Product("Apple", 0.99, buy2Get1);
        Product mask = new Product("Mask", 1.99, noOffer);

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addCart(apple, 2);
        shoppingCart.addCart(apple, 1);
        shoppingCart.addCart(mask, 3);

        Assertions.assertEquals(0.18, shoppingCart.getSalesTax());
        Assertions.assertEquals(9.12, shoppingCart.getTotalCartWithTax());

        Assertions.assertEquals("ShoppingCart{cartItems=[CartItem{product=Product{name='Apple', price=0.99}, quantity=3}," +
                " CartItem{product=Product{name='Mask', price=1.99}, quantity=3}]}", shoppingCart.toString());
        Assertions.assertEquals(1, shoppingCart.getFreeProduct(apple));
        Assertions.assertEquals(0.99, shoppingCart.getDiscount(apple));

    }


    @Test
    void givenEmptyShoppingCart_whenAddSixAppleThreeMask_thenShouldReturnTotalCartPriceWithTax() {
        Offers buy2Get1 = new Offers(2, 1);
        Offers noOffer = new Offers(0, 0);

        Product apple = new Product("Apple", 0.99, buy2Get1);
        Product mask = new Product("Mask", 1.99, noOffer);

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addCart(apple, 5);
        shoppingCart.addCart(apple, 1);
        shoppingCart.addCart(mask, 3);

        Assertions.assertEquals(0.24, shoppingCart.getSalesTax());
        Assertions.assertEquals(12.15, shoppingCart.getTotalCartWithTax());

        Assertions.assertEquals("ShoppingCart{cartItems=[CartItem{product=Product{name='Apple', price=0.99}, quantity=6}," +
                " CartItem{product=Product{name='Mask', price=1.99}, quantity=3}]}", shoppingCart.toString());
        Assertions.assertEquals(1, shoppingCart.getFreeProduct(apple));
        Assertions.assertEquals(0.99, shoppingCart.getDiscount(apple));

    }

    @Test
    void givenEmptyShoppingCart_whenAddThreeAppleWithBuyMoreThanTwoGetOneFreeOffer_thenShouldReturnTotalThreeAppleAndOneFreeApple() {
        Offers buy2Get1 = new Offers(2, 1);

        Product apple = new Product("Apple", 0.99, buy2Get1);

        ShoppingCart shoppingCart = new ShoppingCart();

        shoppingCart.addCart(apple, 3);

        Assertions.assertEquals(0.06, shoppingCart.getSalesTax());
        Assertions.assertEquals(3.03, shoppingCart.getTotalCartWithTax());
        Assertions.assertEquals("ShoppingCart{cartItems=[CartItem{product=Product{name='Apple', price=0.99}, quantity=3}]}", shoppingCart.toString());
        Assertions.assertEquals(1, shoppingCart.getFreeProduct(apple));
        Assertions.assertEquals(0.99, shoppingCart.getDiscount(apple));
    }

    @Test
    void givenEmptyShoppingCart_whenAddOneAppleWithBuyMoreThanTwoGetOneFreeOffer_thenShouldReturnTotalThreeAppleAndZeroFreeApple() {
        Offers buy2Get1 = new Offers(2, 1);

        Product apple = new Product("Apple", 0.99, buy2Get1);

        ShoppingCart shoppingCart = new ShoppingCart();

        shoppingCart.addCart(apple, 1);

        Assertions.assertEquals(0.02, shoppingCart.getSalesTax());
        Assertions.assertEquals(1.01, shoppingCart.getTotalCartWithTax());
        Assertions.assertEquals("ShoppingCart{cartItems=[CartItem{product=Product{name='Apple', price=0.99}, quantity=1}]}", shoppingCart.toString());
        Assertions.assertEquals(0, shoppingCart.getFreeProduct(apple));
        Assertions.assertEquals(0.0, shoppingCart.getDiscount(apple));
    }

    @Test
    void givenEmptyShoppingCart_whenAddTwoAppleWithBuyMoreThanTwoGetOneFreeOffer_thenShouldReturnTotalTwoAppleAndZeroFreeApple() {
        Offers buy2Get1 = new Offers(2, 1);

        Product apple = new Product("Apple", 0.99, buy2Get1);

        ShoppingCart shoppingCart = new ShoppingCart();

        shoppingCart.addCart(apple, 1);
        shoppingCart.addCart(apple, 1);

        Assertions.assertEquals(0.04, shoppingCart.getSalesTax());
        Assertions.assertEquals(2.02, shoppingCart.getTotalCartWithTax());
        Assertions.assertEquals("ShoppingCart{cartItems=[CartItem{product=Product{name='Apple', price=0.99}, quantity=2}]}", shoppingCart.toString());
        Assertions.assertEquals(0, shoppingCart.getFreeProduct(apple));
        Assertions.assertEquals(0.0, shoppingCart.getDiscount(apple));
    }

    @Test
    void givenEmptyShoppingCart_whenAddFiveAppleWithBuyMoreThanTwoGetOneFreeOffer_thenShouldReturnTotalFiveAppleAndOneApple() {
        Offers buy2Get1 = new Offers(2, 1);

        Product apple = new Product("Apple", 0.99, buy2Get1);

        ShoppingCart shoppingCart = new ShoppingCart();

        shoppingCart.addCart(apple, 2);
        shoppingCart.addCart(apple, 2);
        shoppingCart.addCart(apple, 1);

        Assertions.assertEquals(0.1, shoppingCart.getSalesTax());
        Assertions.assertEquals(5.05, shoppingCart.getTotalCartWithTax());
        Assertions.assertEquals("ShoppingCart{cartItems=[CartItem{product=Product{name='Apple', price=0.99}, quantity=5}]}", shoppingCart.toString());
        Assertions.assertEquals(1, shoppingCart.getFreeProduct(apple));
        Assertions.assertEquals(0.99, shoppingCart.getDiscount(apple));
    }

    @Test
    void givenEmptyShoppingCart_whenAddFiveAppleWithBuyMoreThanTwoGetOneFreeOffer_And_OneMaskWithNoOffer_thenShouldReturnTotalThreeAppleAndOneMaskAndOneAppleFree() {
        Offers buy2Get1 = new Offers(2, 1);
        Offers noOffer = new Offers(0, 0);

        Product apple = new Product("Apple", 0.99, buy2Get1);
        Product mask = new Product("Mask", 1.99, noOffer);

        ShoppingCart shoppingCart = new ShoppingCart();

        shoppingCart.addCart(apple, 5);
        shoppingCart.addCart(mask, 1);

        Assertions.assertEquals(0.14, shoppingCart.getSalesTax());
        Assertions.assertEquals(7.08, shoppingCart.getTotalCartWithTax());
        Assertions.assertEquals("ShoppingCart{cartItems=[CartItem{product=Product{name='Apple', price=0.99}, quantity=5}, CartItem{product=Product{name='Mask', price=1.99}, quantity=1}]}", shoppingCart.toString());
        Assertions.assertEquals(1, shoppingCart.getFreeProduct(apple));
        Assertions.assertEquals(0.99, shoppingCart.getDiscount(apple));
    }

    @Test
    void givenEmptyShoppingCart_whenAddThreeAppleWithBuyMoreThanTwoGetOneFreeOffer_thenShouldReturnDiscountOfOneApple() {
        Offers buy2Get1 = new Offers(2, 1);

        Product apple = new Product("Apple", 0.99, buy2Get1);

        ShoppingCart shoppingCart = new ShoppingCart();

        shoppingCart.addCart(apple, 1);
        shoppingCart.addCart(apple, 1);
        shoppingCart.addCart(apple, 1);

        Assertions.assertEquals(0.06, shoppingCart.getSalesTax());
        Assertions.assertEquals(3.03, shoppingCart.getTotalCartWithTax());
        Assertions.assertEquals("ShoppingCart{cartItems=[CartItem{product=Product{name='Apple', price=0.99}, quantity=3}]}", shoppingCart.toString());
        Assertions.assertEquals(1, shoppingCart.getFreeProduct(apple));
        Assertions.assertEquals(0.99, shoppingCart.getDiscount(apple));
    }

    @Test
    void givenEmptyShoppingCart_whenAddMoreThanTenAppleWithTenPercentOff_thenShouldReturnDiscountOfMoreThanOneApple() {
        Offers buy2Get1 = new Offers(2, 1);

        Product apple = new Product("Apple", 0.99, buy2Get1);

        ShoppingCart shoppingCart = new ShoppingCart();

        shoppingCart.addCart(apple, 10);

        Assertions.assertEquals(0.2, shoppingCart.getSalesTax());//0.32
        Assertions.assertEquals(10.1, shoppingCart.getTotalCartWithTax());//16.19
        Assertions.assertEquals("ShoppingCart{cartItems=[CartItem{product=Product{name='Apple', price=0.99}, quantity=10}]}", shoppingCart.toString());
        Assertions.assertEquals(1, shoppingCart.getFreeProduct(apple));
        Assertions.assertEquals(1.01, shoppingCart.getDiscount(apple));

    }

    @Test
    void givenEmptyShoppingCart_whenAddTenAppleAndThreeMaskWithTenPercentOff_thenShouldReturnDiscountWithTenPercent() {
        Offers buy2Get1 = new Offers(2, 1);
        Offers noOffer = new Offers(2, 1);

        Product apple = new Product("Apple", 0.99, buy2Get1);
        Product mask = new Product("Mask", 1.99, noOffer);

        ShoppingCart shoppingCart = new ShoppingCart();

        shoppingCart.addCart(apple, 10);
        shoppingCart.addCart(mask, 3);

        Assertions.assertEquals(0.32, shoppingCart.getSalesTax());//0.32
        Assertions.assertEquals(16.19, shoppingCart.getTotalCartWithTax());//16.19
        Assertions.assertEquals("ShoppingCart{cartItems=[CartItem{product=Product{name='Apple', price=0.99}, quantity=10}, CartItem{product=Product{name='Mask', price=1.99}, quantity=3}]}", shoppingCart.toString());
        Assertions.assertEquals(1, shoppingCart.getFreeProduct(apple));
        Assertions.assertEquals(1.62, shoppingCart.getDiscount(apple));

    }
}
