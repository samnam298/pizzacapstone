public class Drink extends Item {
    private String size;
    private String flavor;

    public Drink(String flavor, String size) {
        super("Drink");
        this.flavor = flavor;
        this.size = size;
    }

    @Override
    public double getPrice() {
        return switch (size.toLowerCase()) {
            case "small" -> 2.00;
            case "medium" -> 2.50;
            case "large" -> 3.00;
            default -> 0;
        };
    }
}
