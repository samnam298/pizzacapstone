package com.pluralsight;

public class RegularTopping extends Topping {

    public RegularTopping(String name) {
        super(name);
    }

    @Override
    public double getPrice(String size) {
        return 0; // free in all taco sizes
    }
}
