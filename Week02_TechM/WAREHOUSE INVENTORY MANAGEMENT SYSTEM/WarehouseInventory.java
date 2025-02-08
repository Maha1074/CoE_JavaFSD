public class WarehouseInventory {
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();
        manager.addProduct(new Product("P001", "Laptop", 10, new Location(1, 2, 3)));
        manager.addProduct(new Product("P002", "Monitor", 5, new Location(2, 1, 1)));
        List<String> order1Items = Arrays.asList("P001", "P002");
        List<String> order2Items = Arrays.asList("P002");
        Order order1 = new Order("O1001", order1Items, Order.Priority.EXPEDITED);
        Order order2 = new Order("O1002", order2Items, Order.Priority.STANDARD);
        try {
            manager.processOrder(order1);
            manager.processOrder(order2);
        } catch (OutOfStockException e) {
            System.out.println(e.getMessage());
        }
    }
}