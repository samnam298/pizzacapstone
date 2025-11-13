package com.pluralsight;

public class StreetTaco extends Taco {

    public StreetTaco() {
        super("3-Taco", "Corn");
        this.name = "Street Taco";

        // Meat
        Meat meat = new Meat("Carne Asada");
        meat.setHasExtra(false);
        addTopping(meat);

        // Regular toppings
        addTopping(new RegularTopping("Onions"));
        addTopping(new RegularTopping("Cilantro"));

        // Sauce
        addTopping(new SauceTopping("Salsa Verde"));

        // Side (lime wedges are included topping)
        addTopping(new RegularTopping("Lime Wedges"));

        // Not deep-fried
        this.isDeepFried = false;
    }
}
