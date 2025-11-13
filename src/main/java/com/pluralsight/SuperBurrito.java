package com.pluralsight;

public class SuperBurrito extends Taco {

    public SuperBurrito() {
        super("Burrito", "Flour");
        this.name = "Super Burrito";

        // Meat
        Meat meat = new Meat("Carnitas");
        meat.setHasExtra(false);
        addTopping(meat);

        // Cheese
        Cheese cheese = new Cheese("Cheddar");
        cheese.setHasExtra(false);
        addTopping(cheese);

        // Regular toppings
        addTopping(new RegularTopping("Pico de Gallo"));
        addTopping(new RegularTopping("Lettuce"));
        addTopping(new RegularTopping("Tomatoes"));

        // Sauce
        addTopping(new SauceTopping("Birria Dipped"));

        // Burrito is not deep fried by default
        this.isDeepFried = false;
    }
}
