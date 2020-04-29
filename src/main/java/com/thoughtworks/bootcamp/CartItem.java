package com.thoughtworks.bootcamp;

import com.thoughtworks.bootcamp.offer.BuyXGetYFree;

import java.util.Optional;

public class CartItem {
    private Product product;
    private int quantity;
    private Optional<Double> total = Optional.empty();
    private Optional<Double> totalDiscount = Optional.empty();

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    private void updatedTotalPrice() {
        total = Optional.of(product.getPrice() * quantity);
    }

    public String getNamet() {
        return product.getName();
    }

    public boolean isExists(Product productName) {
        return this.getNamet().equals(productName.getName());
    }

    public void incrementQuantity(int quantity) {
        this.quantity += quantity;

    }

    public double getDiscount() {
        calculateDiscountForProduct();
        return totalDiscount.get();
    }

    public double getPriceTotal() {
        updatedTotalPrice();
        return total.get();

    }

    private void calculateDiscountForProduct() {
        BuyXGetYFree buyXGetYFree = product.getOffer();
        totalDiscount = Optional.of((((buyXGetYFree != null ? buyXGetYFree.calculateDiscountOnProduct(quantity, product.getPrice()) : 0))));
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "product=" + product +
                ", quantity=" + quantity +
                '}';
    }
}
