import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Item> items = new ArrayList<>();

    public void addItem(Item item) { items.add(item); }

    public List<Item> getItems() { return items; }

    public double calculateTotal() {
        return items.stream().mapToDouble(Item::getPrice).sum();
    }
}
