import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        GroceryStoreContainer storeContainer = new GroceryStoreContainer();
        populateStores(storeContainer);
        // User interface interaction to create grocery lists
    }

    private static void populateStores(GroceryStoreContainer storeContainer) {
        // Creating grocery items
        GroceryItem apples = new GroceryItem("Apples", 0.99, 1);
        GroceryItem bread = new GroceryItem("Bread", 2.49, 2);
        GroceryItem milk = new GroceryItem("Milk", 3.49, 3);
        GroceryItem eggs = new GroceryItem("Eggs", 2.99, 1);
        GroceryItem cheese = new GroceryItem("Cheese", 4.99, 2);
        GroceryItem chicken = new GroceryItem("Chicken", 9.99, 4);
        GroceryItem coffee = new GroceryItem("Coffee", 7.99, 5);

        // Creating stores
        GroceryStore store1 = new GroceryStore("Fresh Market");
        GroceryStore store2 = new GroceryStore("Budget Grocer");

        // Adding items to store1
        store1.addItem(apples);
        store1.addItem(bread);
        store1.addItem(milk);
        store1.addItem(eggs);

        // Adding items to store2 (note that some items are shared between stores, possibly at different prices)
        store2.addItem(apples);
        store2.addItem(cheese);
        store2.addItem(chicken);
        store2.addItem(coffee);

        // Adjust prices for store2 if needed
        // For example, apples might be cheaper or more expensive in store2
        store2.addItem(new GroceryItem("Apples", 0.89, 1)); // A different price for apples in store2

        // Adding stores to the store container
        storeContainer.addStore(store1);
        storeContainer.addStore(store2);
    }
}
