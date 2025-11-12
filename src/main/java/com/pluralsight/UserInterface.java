import java.util.Scanner;

public class UserInterface {
    private Scanner input = new Scanner(System.in);
    private Order currentOrder = new Order();

    public void start() {
        boolean running = true;
        while (running) {
            System.out.println("\n1) New Order\n0) Exit");
            String choice = input.nextLine();
            if (choice.equals("1")) takeOrder();
            else if (choice.equals("0")) running = false;
        }
    }

    private void takeOrder() {
        boolean ordering = true;
        while (ordering) {
            System.out.println("\n1) Add Taco\n2) Add Drink\n3) Add Chips & Salsa\n4) Add Street Taco\n5) Add Super Burrito\n6) Checkout\n0) Cancel");
            String choice = input.nextLine();
            switch (choice) {
                case "1" -> addCustomTaco();
                case "2" -> currentOrder.addItem(new Drink("Cola", "medium"));
                case "3" -> currentOrder.addItem(new ChipsAndSalsa("Salsa Verde"));
                case "4" -> currentOrder.addItem(new StreetTaco());
                case "5" -> currentOrder.addItem(new SuperBurrito());
                case "6" -> { checkout(); ordering = false; }
                case "0" -> ordering = false;
            }
        }
    }

    private void addCustomTaco() {
        Taco taco = new Taco("single", "flour", false);
        taco.addTopping(new Meat("Carne Asada", false));
        taco.addTopping(new Cheese("Oaxaca", false));
        taco.addTopping(new SauceTopping("Salsa Roja", "mild"));
        currentOrder.addItem(taco);
        System.out.println("Custom taco added!");
    }

    private void checkout() {
        System.out.println("\n--- RECEIPT ---");
        for (Item i : currentOrder.getItems())
            System.out.println(i.getName() + " - $" + i.getPrice());
        System.out.println("Total: $" + currentOrder.calculateTotal());
        new ReceiptFileManager().saveReceipt(currentOrder);
    }
}
