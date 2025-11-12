public class ChipsAndSalsa extends Item {
    private String salsaType;

    public ChipsAndSalsa(String salsaType) {
        super("Chips & Salsa");
        this.salsaType = salsaType;
    }

    @Override
    public double getPrice() {
        return 1.50;
    }
}
