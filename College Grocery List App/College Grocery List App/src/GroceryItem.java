public class GroceryItem {
    private final String name;
    private final double unitPrice;
    private final int aisle;

    public GroceryItem(String name, double unitPrice, int aisle) {
        this.name = name;
        this.unitPrice = unitPrice;
        this.aisle = aisle;
    }

    // Getters for item properties
    public String getName() {
        return name;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public int getAisle() {
        return aisle;
    }
}
