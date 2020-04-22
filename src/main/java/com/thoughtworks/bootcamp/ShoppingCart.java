package com.thoughtworks.bootcamp;

import java.util.ArrayList;

public class ShoppingCart {
    ArrayList<Product> products;
    double cartTotal;

    public ShoppingCart(ArrayList<Product> products) {
        this.products = products;
    }

    public double calculateTotalCart() {
        for (Product item : products) {
            cartTotal =cartTotal+ item.quantity * item.price;
        }
        return cartTotal;
    }
}
