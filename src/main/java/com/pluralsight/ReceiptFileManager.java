package com.pluralsight;

import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptFileManager {

    public void saveReceipt(Order order) {
        try {
            String fileName = generateFileName();
            FileWriter writer = new FileWriter("receipts/" + fileName);

            for (Item i : order.getItems()) {
                writer.write(i.getName() + " - $" + i.getPrice() + "\n");
            }

            writer.write("Total: $" + order.calculateTotal());
            writer.close();

        } catch (Exception e) {
            System.out.println("Error writing receipt.");
        }
    }

    public String generateFileName() {
        return LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss")) + ".txt";
    }
}
