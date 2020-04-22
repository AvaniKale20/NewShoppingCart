package com.thoughtworks.bootcamp;

public class ShoppingCart {
    private String apple;
    private int quantity;
    private double price;

    public ShoppingCart(String apple, int quantity, double price) {
        this.apple = apple;
        this.quantity = quantity;
        this.price = price;
    }

    public double calculateCartTotal() {
        return quantity * price;
    }
}
