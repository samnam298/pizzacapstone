public class StreetTaco extends Taco {
    public StreetTaco() {
        super("3-taco", "corn", false);
        addTopping(new Meat("Carne Asada", false));
        addTopping(new RegularTopping("Onions"));
        addTopping(new RegularTopping("Cilantro"));
        addTopping(new SauceTopping("Salsa Verde", "mild"));
    }
}
