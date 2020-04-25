package com.thoughtworks.bootcamp;

public class Product {
    private String name;
    private double price;
    private Offers offers;

    public Product(String name, double price, Offers offers) {
        this.name = name;
        this.price = price;
        this.offers = offers;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

}
