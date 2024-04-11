import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GroceryList {
    private final List<GroceryItemOrder> orders;

    public GroceryList() {
        orders = new ArrayList<>();
    }

    // Add a grocery item order to the list
    public boolean add(GroceryItemOrder order) {
        return orders.add(order);
    }

    // Calculate the total cost of all orders in the list
    public double getTotalCost() {
        return orders.stream().mapToDouble(GroceryItemOrder::getCost).sum();
    }

    // Override the toString method to get a string representation of the list
    @Override
    public String toString() {
        return orders.stream()
                .map(order -> order.getItem().getName() + " x" + order.getQuantity())
                .collect(Collectors.joining(", ", "[", "]"));
    }
}
