package com.thoughtworks.bootcamp;


public class CartItem {
    private Product product;//name price
    private int quantity;

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public boolean isExists(String productName) {
        return product.getName().equals(productName);
    }

    public void incrementQuantity(int quantity) {
        this.quantity += quantity;
    }

    public double getPrice() {
        return product.getPrice() * quantity;
    }

    public int getOnlyOneFree() {
        return product.getOneFree();
    }

    public int getQuantityOfProduct() {
        return quantity;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "product=" + product +
                ", quantity=" + quantity +
                '}';
    }
}
