package com.thoughtworks.bootcamp;


import java.util.Optional;

public class CartItem {
    private Product product;
    private int quantity;
    //    we have to update total and discount
    private Optional<Double> total = Optional.empty();
    private Optional<Double> totalDiscount = Optional.empty();

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
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

    private void updatedTotalPrice() {
        total = Optional.of(product.getPrice() * quantity);
    }

    public void discount() {
        BuyXGetYFree buyXGetYFree = product.getOffer();
        totalDiscount = Optional.of((((buyXGetYFree != null ? buyXGetYFree.calculateDiscountOnProduct(quantity, product.getPrice()) : 0))));
    }

    public double getDiscount() {
        discount();
        return totalDiscount.get();
    }

    public double getPriceTotal() {
        updatedTotalPrice();
        return total.get();

    }

    @Override
    public String toString() {
        return "CartItem{" +
                "product=" + product +
                ", quantity=" + quantity +
                '}';
    }
}
