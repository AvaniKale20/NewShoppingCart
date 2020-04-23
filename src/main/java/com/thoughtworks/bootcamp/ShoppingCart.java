package com.thoughtworks.bootcamp;

import java.text.DecimalFormat;
import java.util.*;

public class ShoppingCart {

    private double amount;
    private static final double salesTaxPercent = 0.02;
    private double total = 0.0;
    Map<String, Integer> productQuantities = new HashMap<>();


    public int getQuantity(String name) {
        return productQuantities.get(name);
    }

    public double getTotalCartWithTax() {
        return total;
    }

    public double getSalesTax() {
        return format(total - amount);
    }

    public void addCart(Product product, int quantity) {
        incrementQuantity(product, quantity);
        amount += getProductTotal(product, quantity);
        total = format(amount * (1 + salesTaxPercent));
    }

    private double getProductTotal(Product product, int quantity) {
        return product.getPrice() * quantity;
    }

    private void incrementQuantity(Product product, int quantity) {
        if (productQuantities.containsKey(product.getName())) {
            Integer existingQuantity = productQuantities.get(product.getName());
            productQuantities.put(product.getName(), existingQuantity + quantity);
            return;
        }
        productQuantities.put(product.getName(), quantity);
    }

    private double format(double value) {
        return Double.parseDouble(new DecimalFormat("##.##").format(value));
    }
}
