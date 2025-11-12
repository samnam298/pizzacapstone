import java.util.ArrayList;
import java.util.List;

public class Taco extends Item {
    private String size;
    private String shell;
    private boolean deepFried;
    private List<Topping> toppings = new ArrayList<>();

    public Taco(String size, String shell, boolean deepFried) {
        super("Taco");
        this.size = size;
        this.shell = shell;
        this.deepFried = deepFried;
    }

    public void addTopping(Topping topping) { toppings.add(topping); }

    public double calculateTotal() {
        double total = switch (size.toLowerCase()) {
            case "single" -> 3.50;
            case "3-taco" -> 9.00;
            case "burrito" -> 8.50;
            default -> 0;
        };
        for (Topping t : toppings) total += t.getPrice(size);
        return total;
    }

    @Override
    public double getPrice() { return calculateTotal(); }
}
