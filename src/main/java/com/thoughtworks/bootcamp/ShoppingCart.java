package com.thoughtworks.bootcamp;

import java.text.DecimalFormat;
import java.util.*;

public class ShoppingCart {

    private static final double salesTaxPercent = 0.02;
    private ShoppingCartCalculator cartCalculator;
    Map<String, Integer> productQuantities = new HashMap<>();

    ShoppingCart() {
        double initialAmount = 0.0;
        double itemsTotal = 0.0;
        this.cartCalculator = new ShoppingCartCalculator(initialAmount, itemsTotal, salesTaxPercent);
    }


    public int getQuantity(String name) {
        return productQuantities.get(name);
    }

    public double getTotalCartWithTax() {
        return cartCalculator.getTotal();
    }

    public double getSalesTax() {
        return cartCalculator.getSalesTax();
    }

    public void addCart(Product product, int quantity) {
        incrementQuantity(product, quantity);
//        amount += getProductTotal(product, quantity);
//        total = format(amount * (1 + salesTaxPercent));
        double amount = getProductTotal(product, quantity);
        cartCalculator.updateAmount(amount);
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
