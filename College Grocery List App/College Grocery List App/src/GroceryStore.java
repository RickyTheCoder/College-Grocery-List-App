import java.util.HashMap;
import java.util.Map;

public class GroceryStore {
    private final String name;
    private final Map<String, GroceryItem> inventory;

    public GroceryStore(String name) {
        this.name = name;
        this.inventory = new HashMap<>();
    }

    // Add a grocery item to the store's inventory
    public void addItem(GroceryItem item) {
        inventory.put(item.getName(), item);
    }

    // Retrieve a grocery item from the store's inventory by name
    public GroceryItem getItem(String itemName) {
        return inventory.get(itemName);
    }

    // Getters for store properties
    public String getName() {
        return name;
    }

    public Map<String, GroceryItem> getInventory() {
        return inventory;
    }
}
