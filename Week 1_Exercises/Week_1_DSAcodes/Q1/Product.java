public class Product {
    private String productId;
    private String productName;
    private int quantity;
    private double price;
    public Product(String productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }
    public String getPId() {
        return productId;
    }
    public void setPId(String productId) {
        this.productId = productId;
    }
    public String getPName() {
        return productName;
    }
    public void setPName(String productName) {
        this.productName = productName;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String toString() {
        return "Product{" + "productId='" + productId + '\'' + ", productName='" + productName + '\'' + ", quantity=" + quantity + ", price=" + price + '}';
    }
}
