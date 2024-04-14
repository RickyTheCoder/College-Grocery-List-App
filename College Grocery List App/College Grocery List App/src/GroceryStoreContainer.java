import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class GroceryStoreContainer {
    private final Map<String, GroceryStore> storeMap;

    public GroceryStoreContainer() {
        this.storeMap = new HashMap<>();
    }

    // Add a grocery store to the container
    public void addStore(GroceryStore store) {
        storeMap.put(store.getName(), store);
    }

    public void recordStore(String storeName) {
        GroceryStore store = new GroceryStore(storeName);
        storeMap.put(store.getName(), store);
    }

    // Retrieve a grocery store from the container by name
    public GroceryStore getStore(String name) {
        return storeMap.get(name);
    }

    // Get a set of all store names in the container
    public Set<String> getStoreNames() {
        return storeMap.keySet();
    }

    public Collection<GroceryStore> getStores() {
        return storeMap.values();
    }
}
