package com.thoughtworks.bootcamp;

import java.text.DecimalFormat;

public class Utility {
    private static final double SALES_TAX = 0.02;

    public double calculateSalesTax(double productTotal, double totalDiscount) {
        return SALES_TAX * (productTotal - totalDiscount);
    }

    public double format(double value) {
        return Double.parseDouble(new DecimalFormat("##.##").format(value));
    }
}
