public class SauceTopping extends Topping {
    private String spiceLevel;

    public SauceTopping(String name, String spiceLevel) {
        super(name);
        this.spiceLevel = spiceLevel;
    }

    @Override
    public double getPrice(String size) {
        return 0.0;
    }
}
