import java.util.ArrayList;
import java.util.List;

// Order class definition
class Order {
    private int orderId;
    private String customerName;
    private double totalPrice;

    public Order(int orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
               "orderId=" + orderId +
               ", customerName='" + customerName + '\'' +
               ", totalPrice=" + totalPrice +
               '}';
    }
}

// Bubble Sort implementation
class BubbleSort {

    public static void bubbleSort(List<Order> orders) {
        int n = orders.size();
        boolean swapped;
        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (orders.get(i - 1).getTotalPrice() > orders.get(i).getTotalPrice()) {
                    // Swap orders[i - 1] and orders[i]
                    Order temp = orders.get(i - 1);
                    orders.set(i - 1, orders.get(i));
                    orders.set(i, temp);
                    swapped = true;
                }
            }
            n--; // Reduce the range of comparison
        } while (swapped);
    }
}

// Quick Sort implementation
class QuickSort {

    public static void quickSort(List<Order> orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    private static int partition(List<Order> orders, int low, int high) {
        double pivot = orders.get(high).getTotalPrice();
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (orders.get(j).getTotalPrice() <= pivot) {
                i++;
                // Swap orders[i] and orders[j]
                Order temp = orders.get(i);
                orders.set(i, orders.get(j));
                orders.set(j, temp);
            }
        }
        // Swap orders[i + 1] and orders[high]
        Order temp = orders.get(i + 1);
        orders.set(i + 1, orders.get(high));
        orders.set(high, temp);

        return i + 1;
    }
}

// Main class to test sorting algorithms
public class Q3 {
    public static void main(String[] args) {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order(1, "Alice", 250.50));
        orders.add(new Order(2, "Bob", 150.75));
        orders.add(new Order(3, "Charlie", 300.00));
        orders.add(new Order(4, "David", 200.25));
        
        System.out.println("Original Orders:");
        printOrders(orders);

        // Bubble Sort
        List<Order> bubbleSortedOrders = new ArrayList<>(orders);
        BubbleSort.bubbleSort(bubbleSortedOrders);
        System.out.println("\nOrders Sorted with Bubble Sort:");
        printOrders(bubbleSortedOrders);

        // Quick Sort
        List<Order> quickSortedOrders = new ArrayList<>(orders);
        QuickSort.quickSort(quickSortedOrders, 0, quickSortedOrders.size() - 1);
        System.out.println("\nOrders Sorted with Quick Sort:");
        printOrders(quickSortedOrders);
    }

    private static void printOrders(List<Order> orders) {
        for (Order order : orders) {
            System.out.println(order);
        }
    }
}

