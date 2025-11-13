package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<Item> items = new ArrayList<>();
    private int orderID;

    public Order() {
        this.orderID = (int)(Math.random() * 100000);
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public List<Item> getItems() {
        return items;
    }

    public double calculateTotal() {
        double total = 0;
        for (Item i : items) {
            total += i.getPrice();
        }
        return total;
    }

    public void printReceipt() {

        System.out.println("==========================");
        System.out.println("        ORDER RECEIPT      ");
        System.out.println("==========================");
        System.out.println("Order ID: " + orderID);

        for (Item item : items) {

            System.out.println("\n" + item.getName() + " - $" + String.format("%.2f", item.getPrice()));

            // ------------------- TACO DETAILS -------------------
            if (item instanceof Taco taco) {
                System.out.println("  Size: " + taco.getSize());
                System.out.println("  Shell: " + taco.getShell());
                System.out.println("  Deep Fried: " + (taco.isDeepFried() ? "Yes" : "No"));
                System.out.println("  Toppings:");

                for (Topping topping : taco.getToppings()) {
                    double toppingPrice = topping.getPrice(taco.getSize());
                    System.out.println("    - " + topping.getName() +
                            " ($" + String.format("%.2f", toppingPrice) + ")");
                }
            }

            // ------------------- DRINK DETAILS -------------------
            if (item instanceof Drink drink) {
                System.out.println("  Size: " + drink.getSize());
                System.out.println("  Flavor: " + drink.getFlavor());
            }

            // ---------------- CHIPS & SALSA DETAILS --------------
            if (item instanceof ChipsAndSalsa chips) {
                System.out.println("  Salsa: " + chips.getSalsaType());
            }
        }

        System.out.println("\n--------------------------");
        System.out.println("TOTAL: $" + String.format("%.2f", calculateTotal()));
        System.out.println("--------------------------\n");
    }
}
