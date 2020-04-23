package com.thoughtworks.bootcamp;

import java.util.*;

public class ShoppingCart {

    private ShoppingCartCalculator cartCalculator;
    private Map<String, Integer> productQuantities = new HashMap<>();

    ShoppingCart() {
        this.cartCalculator = new ShoppingCartCalculator();
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
        if (quantity == 2) {
            int totalQuantityWhenGetOffer = quantity + 1;
            incrementQuantity(product, totalQuantityWhenGetOffer);
        }
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

    public String getContent(ArrayList<Product> products) {
        for (Product product : products) {
            return "cart contains " + productQuantities.get(product.getName()) + " " + product.getName() + " of " + product.getPrice() + " each";
        }
        return null;
    }


}
