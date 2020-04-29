package com.thoughtworks.bootcamp;

public class Utility {
    private static final double SALES_TAX = 0.02;

    public double calculateSalesTax(double productTotal, double totalDiscount) {
        return SALES_TAX * (productTotal - totalDiscount);
    }
}
