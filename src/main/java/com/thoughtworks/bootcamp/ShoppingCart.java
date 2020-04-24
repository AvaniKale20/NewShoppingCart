package com.thoughtworks.bootcamp;

import java.util.*;

public class ShoppingCart {

    private ShoppingCartCalculator cartCalculator;
    private Map<String, Integer> productQuantities = new HashMap<>();
    private Offer offer;

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

    public void addCart(Product product, int quantity, String offer) {
        if (offer.matches("For3Buy2")) {
            int updatedAppleQuantity = ((quantity / 2) * 3);
            incrementQuantity(product, updatedAppleQuantity);

        } else {
            incrementQuantity(product, quantity);
        }
        double amount = getProductTotal(product, quantity);
        cartCalculator.updateAmount(amount);

    }

    //    public void getOffer(Product product, int q, String offer) {
//        List<Integer> list = Arrays.asList(2, 5, 8, 11);
//        int getFRee = 1;
//        int updated = 0;
//        if (offer.matches("For3Buy2"))
//            if (list.contains(q)) {
//                updated = q + getFRee;
    // incrementQuantity(product, updated);

//            }
//       else {
//            incrementQuantity(product, quantity);
//        }
//
//    }

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
