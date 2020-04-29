package com.thoughtworks.bootcamp;

import com.thoughtworks.bootcamp.offer.TenPercentPriceOffer;

import java.util.*;

public class ShoppingCart {
    private final TenPercentPriceOffer tenPercentPriceOffer;
    private Utility utility = new Utility();
    private List<CartItem> cartItems = new ArrayList<>();
    private double tax = 0;
    private double differance = 0;
    private double totalWithTax = 0;
    private double productTotal = 0;
    private double discountForProduct = 0;
    private double discountForPrice = 0;
    private double totalDiscount = 0;

    public ShoppingCart() {
        this.tenPercentPriceOffer = null;
    }

    public ShoppingCart(TenPercentPriceOffer tenPercentPriceOffer) {
        this.tenPercentPriceOffer = tenPercentPriceOffer;
    }

    public void addCart(Product product, int quantity) {
        Optional<CartItem> existingItem = findItem(product);
        if (existingItem.isEmpty()) {
            CartItem cartItem = new CartItem(product, quantity);
            cartItems.add(cartItem);
        } else {
            existingItem.get().incrementQuantity(quantity);
        }
        productTotal = productTotal();
        discountForProduct = discountForProduct();
        discountForPrice = calculateShoppingCartDiscount();
        totalDiscount = utility.format(discountForProduct + discountForPrice);
        tax = utility.format(utility.calculateSalesTax(productTotal, totalDiscount));
        differance = utility.format(productTotal - totalDiscount);
        totalWithTax = utility.format(differance + tax);

    }

    private Optional<CartItem> findItem(Product product) {
        return cartItems.stream().filter(cartItem -> cartItem.isExists(product)).findFirst();
    }

    private double discountForProduct() {
        return cartItems.stream().mapToDouble(CartItem::getDiscount).sum();
    }

    private double productTotal() {
        return cartItems.stream().mapToDouble(CartItem::getPriceTotal).sum();
    }

    private double calculateShoppingCartDiscount() {
        return tenPercentPriceOffer != null ? tenPercentPriceOffer.calculateDiscountForTotalPrice(productTotal - discountForProduct) : 0;
    }

    //------ public
    public double getTotalDiscount() {
        return totalDiscount;
    }

    public double getSalesTax() {
        return utility.format(tax);
    }

    public double getTotalCartWithTax() {
        return utility.format(totalWithTax);
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "cartItems=" + cartItems +
                '}';
    }
}
