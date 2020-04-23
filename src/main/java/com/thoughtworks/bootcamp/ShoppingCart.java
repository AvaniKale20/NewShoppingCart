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
        // if (quantity == 2) {
//        int totalQuantityWhenGetOffer = quantity + 1;
//        incrementQuantity(product, totalQuantityWhenGetOffer);
        //  }
//        else {
//            int totalQuantityWhenGetOffer = quantity - 1;
//            int getFree = totalQuantityWhenGetOffer + 2;
//            incrementQuantity(product, getFree);
        // }
        incrementQuantity(product, quantity);
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

    public String getContent(List<Product> products) {
        String message = "The cart contains ";
        for (int index = 0; index < products.size(); index++) {
            Product product = products.get(index);
            if (products.size() == 1) {
                return (" the cart contains " + productQuantities.get(product.getName()) + " " + product.getName() + " of " + product.getPrice() + " each ");
            } else {
                if (index == products.size() - 1) {
                    message = message.concat(" and ");
                }

                message = message.concat(productQuantities.get(product.getName()) + " " + product.getName() + " of " + product.getPrice() + " each");
            }
        }
        return message;
    }


}
