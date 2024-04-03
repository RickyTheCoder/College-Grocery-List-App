import java.util.ArrayList;
import java.util.List;

public interface Shopper {
    List<GroceryList> groceryLists = new ArrayList<>();

    public default GroceryList recordList(GroceryStore groceryStore) {
        GroceryList list = new GroceryList(groceryStore);
        groceryLists.add(new GroceryList(groceryStore));
        return list;
    }

    public default List<GroceryList> getGroceryLists() {
        return groceryLists;
    }
}
