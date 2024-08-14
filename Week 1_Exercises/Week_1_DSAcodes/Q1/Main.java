public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Product p1 = new Product("101", "Laptop", 10, 999.99);
        Product p2 = new Product("102", "Smartphone", 20, 499.99);
        inventory.addProduct(p1);
        inventory.addProduct(p2);
        inventory.updateProduct("101", 15, 979.99);
        inventory.deleteProduct("102");
        Product p = inventory.getProduct("101");
        System.out.println(p);
        System.out.println(inventory);
    }
}
