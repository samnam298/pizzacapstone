package com.pluralsight;

public class PremiumTopping extends Topping {

    private boolean hasExtra;
    private double extraCost;

    public PremiumTopping(String name, double extraCost) {
        super(name);
        this.extraCost = extraCost;
    }

    public boolean isHasExtra() {
        return hasExtra;
    }

    public void setHasExtra(boolean hasExtra) {
        this.hasExtra = hasExtra;
    }

    @Override
    public double getPrice(String size) {
        double price = switch (size) {
            case "Single" -> extraCost;
            case "3-Taco" -> extraCost * 2;
            case "Burrito" -> extraCost * 3;
            default -> extraCost;
        };

        if (hasExtra) {
            price += extraCost / 2;
        }

        return price;
    }
}
