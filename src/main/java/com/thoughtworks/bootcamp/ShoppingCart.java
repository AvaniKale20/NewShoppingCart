package com.thoughtworks.bootcamp;

public class ShoppingCart {
    private String productName;
    private int quantity;
    private double price;

    public ShoppingCart(String productName, int quantity, double price) {
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public double calculateTotalCart() {
        double cartTotal = quantity * price;
        return cartTotal;
    }
}
