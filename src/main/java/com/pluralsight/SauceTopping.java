package com.pluralsight;

public class SauceTopping extends Topping {

    public SauceTopping(String name) {
        super(name);
    }

    @Override
    public double getPrice(String size) {
        return 0; // sauces are free
    }
}
