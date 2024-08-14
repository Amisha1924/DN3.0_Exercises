import java.util.HashMap;
import java.util.Map;
public class Inventory {
    private Map<String, Product> products;
    public Inventory() {
        products = new HashMap<>();
    }
    public void addProduct(Product product) {
        products.put(product.getPId(), product);
    }
    public void updateProduct(String productId, int quantity, double price) {
        Product product = products.get(productId);
        if (product != null) {
            product.setQuantity(quantity);
            product.setPrice(price);
        }
    }
    public void deleteProduct(String productId) {
        products.remove(productId);
    }
    public Product getProduct(String productId) {
        return products.get(productId);
    }
    public String toString() {
        return "Inventory{" + "products=" + products + '}';
    }
}
