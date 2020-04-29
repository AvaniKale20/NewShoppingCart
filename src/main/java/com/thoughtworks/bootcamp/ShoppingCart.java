package com.thoughtworks.bootcamp;

import java.text.DecimalFormat;
import java.util.*;

public class ShoppingCart {
    private static final double SALES_TAX = 0.02;
    private double tax = 0;
    private double differance = 0;
    private double totalWithTax = 0;
    private double productTotal = 0;
    private double discountForProduct = 0;
    private double discountForPrice = 0;
    private List<CartItem> cartItems = new ArrayList<>();
    private double totalDiscount = 0;
    private TenPercentPriceOffer tenPercentPriceOffer;

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
        productTotal = cartItems.stream().mapToDouble(CartItem::getPriceTotal).sum();//getT
        discountForProduct = discountForProduct();//getD
        discountForPrice = calculateShoppingCartDiscount();
        totalDiscount = format(discountForProduct + discountForPrice);
        tax = format(calculateSalesTax(productTotal, totalDiscount));
        differance = format(productTotal - totalDiscount);
        totalWithTax = format(differance + tax);

    }

    //
//    private CartItem cartItemFor(Product product, int quantity) {
//        CartItem cartItem = new CartItem(product, quantity);
//        itemsTotal += cartItem.getPrice();
//        tax = format(itemsTotal * SALES_TAX_PERCENT);
//        total = itemsTotal + tax;
//        for (CartItem item : cartItems) {
//            if (item.isExists(product.getName())) {
//                cartItem = item;
//                break;
//            }
//        }
//        return cartItem;
//    }

    private Optional<CartItem> findItem(Product product) {
        return cartItems.stream().filter(cartItem -> cartItem.isExists(product)).findFirst();
    }

    private double discountForProduct() {
        return cartItems.stream().mapToDouble(CartItem::getDiscount).sum();
    }

    private double calculateShoppingCartDiscount() {
        return tenPercentPriceOffer != null ? tenPercentPriceOffer.calculateDiscountForTotalPrice(productTotal - discountForProduct) : 0;
    }

    private double format(double value) {
        return Double.parseDouble(new DecimalFormat("##.##").format(value));
    }

    //------
    public double ShoppingCartDiscount() {
        return totalDiscount;
    }

    public double getSalesTax() {
        return format(tax);
    }

    public double getTotalCartWithTax() {
        return format(totalWithTax);
    }

    //-- have to remove in onather class
    public double calculateSalesTax(double productTotal, double totalDiscount) {
        return SALES_TAX * (productTotal - totalDiscount);
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "cartItems=" + cartItems +
                '}';
    }
}
