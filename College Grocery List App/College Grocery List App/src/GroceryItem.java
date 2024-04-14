public class GroceryItem {
    private final String name;
    private final double unitPrice;
    private final String aisle;

    public GroceryItem(String name, double unitPrice, String aisle) {
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

    public String getAisle() {
        return aisle;
    }
}
