package com.pluralsight;

import java.util.Scanner;

public class UserInterface {

    private Scanner input = new Scanner(System.in);
    private Order currentOrder = new Order();
    private ReceiptFileManager receiptManager = new ReceiptFileManager();

    public void start() {

        while (true) {
            clearScreen();
            System.out.println("""
=============================
     WELCOME TO TACO-LICIOUS
=============================

1) New Order
0) Exit
""");

            System.out.print("Choose: ");
            String choice = input.nextLine();

            switch (choice) {
                case "1" -> takeOrder();
                case "0" -> { return; }
                default -> pause("Invalid choice.");
            }
        }
    }

    // ORDER MENU
    private void takeOrder() {
        currentOrder = new Order();

        while (true) {
            clearScreen();
            System.out.println("""
-----------------------------
        BUILD YOUR ORDER
-----------------------------

1) Add Taco
2) Add Drink
3) Add Chips & Salsa
4) Checkout
5) Signature Tacos
0) Cancel Order
""");

            System.out.print("Choose: ");
            String choice = input.nextLine();

            switch (choice) {
                case "1" -> addTaco();
                case "2" -> addDrink();
                case "3" -> addChips();
                case "4" -> checkout();
                case "5" -> signatureTacoMenu();
                case "0" -> { return; }
                default -> pause("Invalid option.");
            }
        }
    }

    // SIGNATURE TACOS
    private void signatureTacoMenu() {
        clearScreen();
        System.out.println("""
Signature Tacos:
1) Street Taco
2) Super Burrito
0) Back
""");

        System.out.print("Choose: ");
        String choice = input.nextLine();

        switch (choice) {
            case "1" -> {
                currentOrder.addItem(new StreetTaco());
                pause("Street Taco added!");
            }
            case "2" -> {
                currentOrder.addItem(new SuperBurrito());
                pause("Super Burrito added!");
            }
            case "0" -> { return; }
            default -> pause("Invalid choice.");
        }
    }

    // TACO BUILDER
    private void addTaco() {
        clearScreen();

        // SIZE
        System.out.println("""
Taco Size:
1) Single
2) 3-Taco
3) Burrito
""");

        System.out.print("Choose: ");
        String size = switch (input.nextLine()) {
            case "1" -> "Single";
            case "2" -> "3-Taco";
            case "3" -> "Burrito";
            default -> "Single";
        };

        // SHELL
        clearScreen();
        System.out.println("""
Choose Shell:
1) Corn
2) Flour
3) Hard Shell
4) Bowl
""");

        System.out.print("Choose: ");
        String shell = switch (input.nextLine()) {
            case "1" -> "Corn";
            case "2" -> "Flour";
            case "3" -> "Hard Shell";
            case "4" -> "Bowl";
            default -> "Corn";
        };

        Taco taco = new Taco(size, shell);

        // MEAT
        clearScreen();
        System.out.println("""
Choose Meat:
1) Carne Asada
2) Al Pastor
3) Carnitas
4) Pollo
5) Chorizo
6) Pescado
0) No Meat
""");

        String meatChoice = input.nextLine();

        if (!meatChoice.equals("0")) {
            Meat meat = switch (meatChoice) {
                case "1" -> new Meat("Carne Asada");
                case "2" -> new Meat("Al Pastor");
                case "3" -> new Meat("Carnitas");
                case "4" -> new Meat("Pollo");
                case "5" -> new Meat("Chorizo");
                case "6" -> new Meat("Pescado");
                default -> null;
            };
            if (meat != null) {
                System.out.print("Extra meat? (y/n): ");
                meat.setHasExtra(input.nextLine().equalsIgnoreCase("y"));
                taco.addTopping(meat);
            }
        }

        // CHEESE
        clearScreen();
        System.out.println("""
Choose Cheese:
1) Queso Fresco
2) Oaxaca
3) Cotija
4) Cheddar
0) No Cheese
""");

        String cheeseChoice = input.nextLine();

        if (!cheeseChoice.equals("0")) {
            Cheese cheese = switch (cheeseChoice) {
                case "1" -> new Cheese("Queso Fresco");
                case "2" -> new Cheese("Oaxaca");
                case "3" -> new Cheese("Cotija");
                case "4" -> new Cheese("Cheddar");
                default -> null;
            };
            if (cheese != null) {
                System.out.print("Extra cheese? (y/n): ");
                cheese.setHasExtra(input.nextLine().equalsIgnoreCase("y"));
                taco.addTopping(cheese);
            }
        }

        // REGULAR TOPPINGS
        boolean addingToppings = true;
        while (addingToppings) {
            clearScreen();
            System.out.println("""
Add Regular Toppings:

1) Lettuce
2) Cilantro
3) Onions
4) Tomatoes
5) Jalapenos
6) Radishes
7) Pico
8) Guacamole
9) Corn
0) Done
""");

            System.out.print("Choose: ");
            String topChoice = input.nextLine();

            switch (topChoice) {
                case "1" -> taco.addTopping(new RegularTopping("Lettuce"));
                case "2" -> taco.addTopping(new RegularTopping("Cilantro"));
                case "3" -> taco.addTopping(new RegularTopping("Onions"));
                case "4" -> taco.addTopping(new RegularTopping("Tomatoes"));
                case "5" -> taco.addTopping(new RegularTopping("Jalapenos"));
                case "6" -> taco.addTopping(new RegularTopping("Radishes"));
                case "7" -> taco.addTopping(new RegularTopping("Pico"));
                case "8" -> taco.addTopping(new RegularTopping("Guacamole"));
                case "9" -> taco.addTopping(new RegularTopping("Corn"));
                case "0" -> {
                    pause("Finished adding regular toppings!");
                    addingToppings = false;
                }
                default -> {
                    pause("Invalid option.");
                    continue;
                }
            }

            if (addingToppings && !topChoice.equals("0")) {
                pause("Topping added!");
            }
        }

        // SAUCES
        boolean addingSauces = true;
        while (addingSauces) {
            clearScreen();
            System.out.println("""
Add Sauces:

1) Salsa Verde
2) Salsa Roja
3) Chipotle
4) Habanero
5) Mild
6) Extra Hot
0) Done
""");

            System.out.print("Choose: ");
            String sauceChoice = input.nextLine();

            switch (sauceChoice) {
                case "1" -> taco.addTopping(new SauceTopping("Salsa Verde"));
                case "2" -> taco.addTopping(new SauceTopping("Salsa Roja"));
                case "3" -> taco.addTopping(new SauceTopping("Chipotle"));
                case "4" -> taco.addTopping(new SauceTopping("Habanero"));
                case "5" -> taco.addTopping(new SauceTopping("Mild"));
                case "6" -> taco.addTopping(new SauceTopping("Extra Hot"));
                case "0" -> {
                    pause("Finished adding sauces!");
                    addingSauces = false;
                }
                default -> {
                    pause("Invalid option.");
                    continue;
                }
            }

            if (addingSauces && !sauceChoice.equals("0")) {
                pause("Sauce added!");
            }
        }

        // DEEP FRIED
        System.out.print("Deep fried? (y/n): ");
        taco.setDeepFried(input.nextLine().equalsIgnoreCase("y"));

        currentOrder.addItem(taco);
        pause("Custom Taco Added!");
    }

    // DRINKS
    private void addDrink() {
        clearScreen();
        System.out.println("""
Choose Drink Flavor:
1) Cola
2) Lemonade
3) Horchata
4) Jamaica
""");

        System.out.print("Flavor: ");
        String flavor = switch (input.nextLine()) {
            case "1" -> "Cola";
            case "2" -> "Lemonade";
            case "3" -> "Horchata";
            case "4" -> "Jamaica";
            default -> "Cola";
        };

        System.out.println("""
Choose Size:
1) Small
2) Medium
3) Large
""");

        System.out.print("Size: ");
        String size = switch (input.nextLine()) {
            case "1" -> "Small";
            case "2" -> "Medium";
            case "3" -> "Large";
            default -> "Medium";
        };

        currentOrder.addItem(new Drink(size, flavor));
        pause("Drink added!");
    }

    // CHIPS & SALSA
    private void addChips() {
        clearScreen();
        System.out.println("""
Choose Salsa Type:
1) Salsa Verde
2) Mild
3) Hot
""");

        System.out.print("Choose: ");
        String salsa = switch (input.nextLine()) {
            case "1" -> "Salsa Verde";
            case "2" -> "Mild Salsa";
            case "3" -> "Hot Salsa";
            default -> "Salsa Verde";
        };

        currentOrder.addItem(new ChipsAndSalsa(salsa));
        pause("Chips & Salsa added!");
    }

    // CHECKOUT
    private void checkout() {
        clearScreen();
        currentOrder.printReceipt();

        System.out.println("1) Confirm Order");
        System.out.println("0) Cancel");

        System.out.print("Choose: ");
        String choice = input.nextLine();

        if (choice.equals("1")) {
            receiptManager.saveReceipt(currentOrder);
            pause("Order Complete! Receipt Saved.");
        }
    }

    // UTILITIES
    private void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private void pause(String msg) {
        System.out.println("\n" + msg);
        System.out.println("Press ENTER to continue...");
        input.nextLine();
    }
}