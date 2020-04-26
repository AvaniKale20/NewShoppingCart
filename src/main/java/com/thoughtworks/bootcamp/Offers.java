package com.thoughtworks.bootcamp;

public class Offers {
    private int buyMoreThanTwo;
    private int getFree;

    public Offers(int buyMoreThanTwo, int getFree) {
        this.buyMoreThanTwo = buyMoreThanTwo;
        this.getFree = getFree;
    }

    public int getOneFree() {
        return this.getFree;
    }

    @Override
    public String toString() {
        return "Offers{" +
                "buyMoreThanTwo=" + buyMoreThanTwo +
                ", getFree=" + getFree +
                '}';
    }

}
