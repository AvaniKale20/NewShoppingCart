package com.thoughtworks.bootcamp;

import java.util.Arrays;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private ArrayList<Product> products;
    private double cartTotal;
    static final double salesTax = 0.02;

    public ShoppingCart(ArrayList<Product> products) {
        this.products = products;
    }

    public List<Double> calculateTotalCart() {
        for (Product item : products) {
            cartTotal = cartTotal + item.quantity * item.price;
        }
        double totalCartWithTax = Double.parseDouble(new DecimalFormat("##.##").format(cartTotal * (1 + salesTax)));
        double salesTax = Double.parseDouble(new DecimalFormat("##.##").format(totalCartWithTax - cartTotal));
        return Arrays.asList(salesTax, totalCartWithTax);
    }
}
