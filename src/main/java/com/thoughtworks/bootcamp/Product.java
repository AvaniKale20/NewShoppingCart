package com.thoughtworks.bootcamp;

public class Product {
    private String productName;
    public int quantity;
    public double price;


    public Product(String productName, int quantity, double price) {
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }
}
