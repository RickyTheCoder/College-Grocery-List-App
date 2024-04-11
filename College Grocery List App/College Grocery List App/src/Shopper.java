import java.util.ArrayList;
import java.util.List;

public interface Shopper {
    List<GroceryList> groceryLists = new ArrayList<>();

    public default GroceryList recordList() {
        GroceryList list = new GroceryList();
        groceryLists.add(list);
        return list;
    }

    public default List<GroceryList> getGroceryLists() {
        return groceryLists;
    }
}
