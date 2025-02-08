public class Main {
    public static void main(String[] args) {
        LibraryManager library = new LibraryManager();
        library.addBook(new Book("Java Programming", "John Doe", "12345"));
        library.addUser(new User("Alice", "U001"));
        
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(() -> {
            try { library.borrowBook("12345", "U001"); } catch (Exception e) { System.out.println(e.getMessage()); }
        });
        executor.execute(() -> {
            try { library.returnBook("12345", "U001"); } catch (Exception e) { System.out.println(e.getMessage()); }
        });
        executor.shutdown();
    }
}