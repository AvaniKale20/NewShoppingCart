package com.thoughtworks.bootcamp;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class ShoppingCart {
    private ArrayList<Product> products;
    private double cartTotal;
    static final double salesTax = 0.02;

    public ShoppingCart(ArrayList<Product> products) {
        this.products = products;
    }

    public double calculateTotalCart() {
        for (Product item : products) {
            cartTotal = cartTotal + item.quantity * item.price;
        }
        return Double.parseDouble(new DecimalFormat("##.##").format(cartTotal * (1 + salesTax)));
    }
}
