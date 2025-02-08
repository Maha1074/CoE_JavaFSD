class InventoryManager {
    private ConcurrentHashMap<String, Product> products = new ConcurrentHashMap<>();
    private PriorityQueue<Order> orderQueue = new PriorityQueue<>(new OrderComparator());

    public synchronized void addProduct(Product product) {
        products.put(product.getProductID(), product);
    }

    public synchronized void processOrder(Order order) throws OutOfStockException {
        for (String productID : order.getProductIDs()) {
            Product product = products.get(productID);
            if (product == null || product.getQuantity() <= 0) {
                throw new OutOfStockException("Product " + productID + " is out of stock!");
            }
            product.setQuantity(product.getQuantity() - 1);
        }
        System.out.println("Order " + order.getOrderID() + " processed.");
    }

    public void startProcessingOrders() {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        while (!orderQueue.isEmpty()) {
            Order order = orderQueue.poll();
            executor.submit(() -> {
                try {
                    processOrder(order);
                } catch (OutOfStockException e) {
                    System.out.println(e.getMessage());
                }
            });
        }
        executor.shutdown();
    }
}