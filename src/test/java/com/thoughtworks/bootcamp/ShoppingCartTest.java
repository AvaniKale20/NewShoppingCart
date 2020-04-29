package com.thoughtworks.bootcamp;

import com.thoughtworks.bootcamp.offer.BuyXGetYFree;
import com.thoughtworks.bootcamp.offer.TenPercentPriceOffer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ShoppingCartTest {
    @Test
    void givenEmptyShoppingCart_whenAddOneApple_thenShouldReturnTotalCartPriceZeroPointNineNine() {
        BuyXGetYFree buy2Get1 = new BuyXGetYFree(2, 1);
        Product apple = new Product("Apple", 0.99, buy2Get1);

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addCart(apple, 1);

        assertEquals(0.02, shoppingCart.getSalesTax());
        assertEquals(1.01, shoppingCart.getTotalCartWithTax());
        assertEquals("ShoppingCart{cartItems=[CartItem{product=Product{name='Apple', price=0.99}, quantity=1}]}", shoppingCart.toString());
        assertEquals(0.0, shoppingCart.getTotalDiscount());

    }


    @Test
    void givenEmptyShoppingCart_whenAddFiveApple_thenShouldReturnTotalCartPriceZeroPointNineNine() {
        BuyXGetYFree buy2Get1 = new BuyXGetYFree(2, 1);
        Product apple = new Product("Apple", 0.99, buy2Get1);

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addCart(apple, 5);

        assertEquals(0.08, shoppingCart.getSalesTax());
        assertEquals(4.04, shoppingCart.getTotalCartWithTax());
        assertEquals("ShoppingCart{cartItems=[CartItem{product=Product{name='Apple', price=0.99}, quantity=5}]}", shoppingCart.toString());
        assertEquals(0.99, shoppingCart.getTotalDiscount());
    }


    @Test
    void givenEmptyShoppingCart_whenAddOneMask_thenShouldReturnTotalCartPriceOnrPointNineNine() {

        Product mask = new Product("Mask", 1.99);

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addCart(mask, 1);


        assertEquals(0.04, shoppingCart.getSalesTax());
        assertEquals(2.03, shoppingCart.getTotalCartWithTax());
        assertEquals("ShoppingCart{cartItems=[CartItem{product=Product{name='Mask', price=1.99}, quantity=1}]}", shoppingCart.toString());

    }

    @Test
    void givenEmptyShoppingCart_whenAddOneMaskAndOneApple_thenShouldReturnTotalCartPriceTwoPointNineEight() {
        BuyXGetYFree buy2Get1 = new BuyXGetYFree(2, 1);
        Product apple = new Product("Apple", 0.99, buy2Get1);
        Product mask = new Product("Mask", 1.99);

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addCart(apple, 1);
        shoppingCart.addCart(mask, 1);

        assertEquals(0.06, shoppingCart.getSalesTax());
        assertEquals(3.04, shoppingCart.getTotalCartWithTax());

        assertEquals("ShoppingCart{cartItems=[CartItem{product=Product{name='Apple', price=0.99}, quantity=1}," +
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
        assertEquals(0.16, shoppingCart.getSalesTax());
        assertEquals(8.11, shoppingCart.getTotalCartWithTax());

        assertEquals("ShoppingCart{cartItems=[CartItem{product=Product{name='Apple', price=0.99}, quantity=3}, " +
                "CartItem{product=Product{name='Mask', price=1.99}, quantity=3}]}", shoppingCart.toString());
        assertEquals(0.99, shoppingCart.getTotalDiscount());

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

        assertEquals(0.16, shoppingCart.getSalesTax());
        assertEquals(8.11, shoppingCart.getTotalCartWithTax());
        assertEquals("ShoppingCart{cartItems=[CartItem{product=Product{name='Apple', price=0.99}, quantity=3}," +
                " CartItem{product=Product{name='Mask', price=1.99}, quantity=3}]}", shoppingCart.toString());
        assertEquals(0.99, shoppingCart.getTotalDiscount());


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

        assertEquals(0.2, shoppingCart.getSalesTax());
        assertEquals(10.13, shoppingCart.getTotalCartWithTax());

        assertEquals("ShoppingCart{cartItems=[CartItem{product=Product{name='Apple', price=0.99}, quantity=6}," +
                " CartItem{product=Product{name='Mask', price=1.99}, quantity=3}]}", shoppingCart.toString());
        assertEquals(1.98, shoppingCart.getTotalDiscount());

    }

        @Test
    void givenEmptyShoppingCart_whenAddThreeAppleWithBuyMoreThanTwoGetOneFreeOffer_thenShouldReturnTotalThreeAppleAndOneFreeApple() {
        BuyXGetYFree buy2Get1 = new BuyXGetYFree(2, 1);

        Product apple = new Product("Apple", 0.99, buy2Get1);

        ShoppingCart shoppingCart = new ShoppingCart();

        shoppingCart.addCart(apple, 3);

        assertEquals(0.04, shoppingCart.getSalesTax());
        assertEquals(2.02, shoppingCart.getTotalCartWithTax());
        assertEquals("ShoppingCart{cartItems=[CartItem{product=Product{name='Apple', price=0.99}, quantity=3}]}", shoppingCart.toString());
        assertEquals(0.99, shoppingCart.getTotalDiscount());
    }

    @Test
    void givenEmptyShoppingCart_whenAddOneAppleWithBuyMoreThanTwoGetOneFreeOffer_thenShouldReturnTotalThreeAppleAndZeroFreeApple() {
        BuyXGetYFree buy2Get1 = new BuyXGetYFree(2, 1);

        Product apple = new Product("Apple", 0.99, buy2Get1);

        ShoppingCart shoppingCart = new ShoppingCart();

        shoppingCart.addCart(apple, 1);

        assertEquals(0.02, shoppingCart.getSalesTax());
        assertEquals(1.01, shoppingCart.getTotalCartWithTax());
        assertEquals("ShoppingCart{cartItems=[CartItem{product=Product{name='Apple', price=0.99}, quantity=1}]}", shoppingCart.toString());
        assertEquals(0.0, shoppingCart.getTotalDiscount());
    }

    @Test
    void givenEmptyShoppingCart_whenAddTwoAppleWithBuyMoreThanTwoGetOneFreeOffer_thenShouldReturnTotalTwoAppleAndZeroFreeApple() {
        BuyXGetYFree buy2Get1 = new BuyXGetYFree(2, 1);

        Product apple = new Product("Apple", 0.99, buy2Get1);

        ShoppingCart shoppingCart = new ShoppingCart();

        shoppingCart.addCart(apple, 1);
        shoppingCart.addCart(apple, 1);

        assertEquals(0.04, shoppingCart.getSalesTax());
        assertEquals(2.02, shoppingCart.getTotalCartWithTax());
        assertEquals("ShoppingCart{cartItems=[CartItem{product=Product{name='Apple', price=0.99}, quantity=2}]}", shoppingCart.toString());
        assertEquals(0.0, shoppingCart.getTotalDiscount());
    }

    @Test
    void givenEmptyShoppingCart_whenAddFiveAppleWithBuyMoreThanTwoGetOneFreeOffer_thenShouldReturnTotalFiveAppleAndOneApple() {
        BuyXGetYFree buy2Get1 = new BuyXGetYFree(2, 1);

        Product apple = new Product("Apple", 0.99, buy2Get1);

        ShoppingCart shoppingCart = new ShoppingCart();

        shoppingCart.addCart(apple, 2);
        shoppingCart.addCart(apple, 2);
        shoppingCart.addCart(apple, 1);

        assertEquals(0.08, shoppingCart.getSalesTax());
        assertEquals(4.04, shoppingCart.getTotalCartWithTax());
        assertEquals("ShoppingCart{cartItems=[CartItem{product=Product{name='Apple', price=0.99}, quantity=5}]}", shoppingCart.toString());
        assertEquals(0.99, shoppingCart.getTotalDiscount());
    }

    @Test
    void givenEmptyShoppingCart_whenAddFiveAppleWithBuyMoreThanTwoGetOneFreeOffer_And_OneMaskWithNoOffer_thenShouldReturnTotalThreeAppleAndOneMaskAndOneAppleFree() {
        BuyXGetYFree buy2Get1 = new BuyXGetYFree(2, 1);
        Product apple = new Product("Apple", 0.99, buy2Get1);
        Product mask = new Product("Mask", 1.99);

        ShoppingCart shoppingCart = new ShoppingCart();

        shoppingCart.addCart(apple, 5);
        shoppingCart.addCart(mask, 1);

        assertEquals(0.12, shoppingCart.getSalesTax());
        assertEquals(6.07, shoppingCart.getTotalCartWithTax());
        assertEquals("ShoppingCart{cartItems=[CartItem{product=Product{name='Apple', price=0.99}, quantity=5}, CartItem{product=Product{name='Mask', price=1.99}, quantity=1}]}", shoppingCart.toString());
        assertEquals(0.99, shoppingCart.getTotalDiscount());
    }

    @Test
    void givenEmptyShoppingCart_whenAddThreeAppleWithBuyMoreThanTwoGetOneFreeOffer_thenShouldReturnDiscountOfOneApple() {
        BuyXGetYFree buy2Get1 = new BuyXGetYFree(2, 1);

        Product apple = new Product("Apple", 0.99, buy2Get1);

        ShoppingCart shoppingCart = new ShoppingCart();

        shoppingCart.addCart(apple, 1);
        shoppingCart.addCart(apple, 1);
        shoppingCart.addCart(apple, 1);

        assertEquals(0.04, shoppingCart.getSalesTax());
        assertEquals(2.02, shoppingCart.getTotalCartWithTax());
        assertEquals("ShoppingCart{cartItems=[CartItem{product=Product{name='Apple', price=0.99}, quantity=3}]}", shoppingCart.toString());
        assertEquals(0.99, shoppingCart.getTotalDiscount());
    }

    @Test
    void givenEmptyShoppingCart_whenAddMoreThanTenAppleWithTenPercentOff_thenShouldReturnDiscountOfMoreThanOneApple() {
        BuyXGetYFree buy2Get1 = new BuyXGetYFree(2, 1);
        TenPercentPriceOffer tenPercentPriceOffer = new TenPercentPriceOffer(10.00, 10);

        Product apple = new Product("Apple", 0.99, buy2Get1);

        ShoppingCart shoppingCart = new ShoppingCart(tenPercentPriceOffer);

        shoppingCart.addCart(apple, 10);

        assertEquals(0.14, shoppingCart.getSalesTax());
        assertEquals(7.07, shoppingCart.getTotalCartWithTax());
        assertEquals("ShoppingCart{cartItems=[CartItem{product=Product{name='Apple', price=0.99}, quantity=10}]}", shoppingCart.toString());
        assertEquals(2.97, shoppingCart.getTotalDiscount());

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


        assertEquals(0.23, shoppingCart.getSalesTax());
        assertEquals(11.84, shoppingCart.getTotalCartWithTax());//11.61+0.23=11.84
        assertEquals("ShoppingCart{cartItems=[CartItem{product=Product{name='Apple', price=0.99}, quantity=10}, CartItem{product=Product{name='Mask', price=1.99}, quantity=3}]}", shoppingCart.toString());
        assertEquals(4.26, shoppingCart.getTotalDiscount());


    }
    @Test
    void givenEmptyShoppingCart_whenAddTenAppleOneByOneAndThreeMaskWith_thenShouldReturnDiscountWithTenPercencent
            () {
        BuyXGetYFree buy2Get1 = new BuyXGetYFree(2, 1);
        TenPercentPriceOffer tenPercentPriceOffer = new TenPercentPriceOffer(10.00, 10);

        Product apple = new Product("Apple", 0.99, buy2Get1);
        Product mask = new Product("Mask", 1.99);//null

        ShoppingCart shoppingCart = new ShoppingCart(tenPercentPriceOffer);

        shoppingCart.addCart(apple, 1);
        shoppingCart.addCart(apple, 1);
        shoppingCart.addCart(apple, 1);
        shoppingCart.addCart(apple, 1);
        shoppingCart.addCart(apple, 1);
        shoppingCart.addCart(apple, 1);
        shoppingCart.addCart(apple, 1);
        shoppingCart.addCart(apple, 1);
        shoppingCart.addCart(apple, 1);
        shoppingCart.addCart(apple, 1);
        shoppingCart.addCart(mask, 3);


        assertEquals(0.23, shoppingCart.getSalesTax());
        assertEquals(11.84, shoppingCart.getTotalCartWithTax());//11.61+0.23=11.84
        assertEquals("ShoppingCart{cartItems=[CartItem{product=Product{name='Apple', price=0.99}, quantity=10}, CartItem{product=Product{name='Mask', price=1.99}, quantity=3}]}", shoppingCart.toString());
        assertEquals(4.26, shoppingCart.getTotalDiscount());


    }

}
