package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Taco extends Item {

    private String size;          // Single, 3-Taco, Burrito
    protected String shell;       // corn, flour, hard shell, bowl
    protected boolean isDeepFried;

    private List<Topping> toppings = new ArrayList<>();

    public Taco(String size, String shell) {
        super("Taco");
        this.size = size;
        this.shell = shell;
        this.isDeepFried = false;
    }

    // -----------------------------
    // TOPPING MANAGEMENT
    // -----------------------------
    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    // -----------------------------
    // PRICE CALCULATION
    // -----------------------------
    public double calculateTotal() {
        double base = switch (size) {
            case "Single" -> 3.50;
            case "3-Taco" -> 9.00;
            case "Burrito" -> 8.50;
            default -> 3.50;
        };

        for (Topping t : toppings) {
            base += t.getPrice(size);
        }

        return base;
    }

    @Override
    public double getPrice() {
        return calculateTotal();
    }

    // -----------------------------
    // GETTERS & SETTERS (REQUIRED)
    // -----------------------------
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getShell() {
        return shell;
    }

    public boolean isDeepFried() {
        return isDeepFried;
    }

    public void setDeepFried(boolean deepFried) {
        this.isDeepFried = deepFried;
    }
}
