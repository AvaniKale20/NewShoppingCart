package com.thoughtworks.bootcamp.offer;

public class TenPercentPriceOffer {
    private double buyMoreThanAmount;
    private double discountPercent;

    public TenPercentPriceOffer(double buyMoreThanAmount, double discountPercent) {
        this.buyMoreThanAmount = buyMoreThanAmount;
        this.discountPercent = discountPercent;
    }


    public double calculateDiscountForTotalPrice(double total) {
        if (total >= buyMoreThanAmount) {
            return discountPercent / 100 * total;
        }
        return 0;
    }
}
