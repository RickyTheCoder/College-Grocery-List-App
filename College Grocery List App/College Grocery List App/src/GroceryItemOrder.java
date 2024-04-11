public class GroceryItemOrder {
    private final GroceryItem item;
    private final int quantity;

    public GroceryItemOrder(GroceryItem item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    // Calculate the cost of the order based on item price and quantity
    public double getCost() {
        return item.getUnitPrice() * quantity;
    }

    // Getters for order properties
    public GroceryItem getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }
}