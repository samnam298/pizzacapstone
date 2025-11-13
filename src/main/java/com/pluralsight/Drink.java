package com.pluralsight;

public class Drink extends Item {

    private String size;
    private String flavor;

    public Drink(String size, String flavor) {
        super("Drink");
        this.size = size;
        this.flavor = flavor;
    }

    public String getSize() { return size; }
    public String getFlavor() { return flavor; }

    @Override
    public double getPrice() {
        return switch (size) {
            case "Small" -> 2.00;
            case "Medium" -> 2.50;
            case "Large" -> 3.00;
            default -> 2.00;
        };
    }
}
