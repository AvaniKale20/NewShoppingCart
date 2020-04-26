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

//    public void buyMoreThan2() {
//        offers.buyMoreThanTwo();
//    }

    public int getOneFree() {
        return offers.getOneFree();

    }

    public int noOffer() {
        return 0;
    }


    @Override
        public String toString () {
            return "Product{" +
                    "name='" + name + '\'' +
                    ", price=" + price +
                    '}';
        }
    }
