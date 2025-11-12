public class SuperBurrito extends Taco {
    public SuperBurrito() {
        super("burrito", "flour", false);
        addTopping(new Meat("Carnitas", false));
        addTopping(new Cheese("Cheddar", false));
        addTopping(new RegularTopping("Pico de Gallo"));
        addTopping(new RegularTopping("Lettuce"));
        addTopping(new RegularTopping("Tomatoes"));
    }
}
