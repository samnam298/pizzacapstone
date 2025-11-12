import java.io.FileWriter;
import java.io.IOException;
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
            System.out.println("Receipt saved: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String generateFileName() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        return LocalDateTime.now().format(fmt) + ".txt";
    }
}
