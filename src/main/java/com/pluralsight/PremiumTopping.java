public class PremiumTopping extends Topping {
    private boolean hasExtra;

    public PremiumTopping(String name, boolean hasExtra) {
        super(name);
        this.hasExtra = hasExtra;
    }

    @Override
    public double getPrice(String size) {
        double base = 0;
        switch (size.toLowerCase()) {
            case "single" -> base = 1.00;
            case "3-taco" -> base = 2.00;
            case "burrito" -> base = 3.00;
        }
        if (hasExtra) base += 0.50;
        return base;
    }
}
