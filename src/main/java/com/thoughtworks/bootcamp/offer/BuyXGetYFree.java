package com.thoughtworks.bootcamp.offer;

public class BuyXGetYFree {
    private int buyMoreThanTwo;
    private int getFree;

    public BuyXGetYFree(int buyMoreThanTwo, int getFree) {
        this.buyMoreThanTwo = buyMoreThanTwo;
        this.getFree = getFree;
    }

    private int calculateFreeProduct(int quantity) {
        return quantity / (buyMoreThanTwo + getFree) * getFree;
    }

    public double calculateDiscountOnProduct(int quantity, double price) {
        if (quantity >= buyMoreThanTwo) {
            return calculateFreeProduct(quantity) * price;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Offers{" +
                "buyMoreThanTwo=" + buyMoreThanTwo +
                ", getFree=" + getFree +
                '}';
    }

}
