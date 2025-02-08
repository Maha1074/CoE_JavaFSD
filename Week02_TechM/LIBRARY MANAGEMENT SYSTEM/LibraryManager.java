import java.io.*;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LibraryManager extends LibrarySystem {
    private static final int MAX_BOOKS = 3;
    private static final String DATA_FILE = "library_data.dat";
    
    public LibraryManager() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
        loadLibraryData();
    }
    
    public void addBook(Book book) { books.add(book); }
    public void addUser(User user) { users.add(user); }
    
    public void borrowBook(String ISBN, String userID) throws Exception {
        lock.lock();
        try {
            User user = getUser(userID);
            Book book = getBook(ISBN);
            if (user.getBorrowedBooks().size() >= MAX_BOOKS)
                throw new Exception("User has reached max book limit.");
            if (book.isBorrowed())
                throw new Exception("Book is already borrowed.");
            book.setBorrowed(true);
            user.borrowBook(book);
            System.out.println(user.getName() + " borrowed " + book.getTitle());
            saveLibraryData();
        } finally {
            lock.unlock();
        }
    }
    
    public void returnBook(String ISBN, String userID) throws Exception {
        lock.lock();
        try {
            User user = getUser(userID);
            Book book = getBook(ISBN);
            if (!user.getBorrowedBooks().contains(book))
                throw new Exception("User didn't borrow this book.");
            book.setBorrowed(false);
            user.returnBook(book);
            System.out.println(user.getName() + " returned " + book.getTitle());
            saveLibraryData();
        } finally {
            lock.unlock();
        }
    }
    
    public void reserveBook(String ISBN, String userID) throws Exception {
        lock.lock();
        try {
            System.out.println("Reservation feature not implemented.");
        } finally {
            lock.unlock();
        }
    }
    
    public Book searchBook(String title) {
        return books.stream().filter(book -> book.getTitle().equalsIgnoreCase(title)).findFirst().orElse(null);
    }
    
    private User getUser(String userID) throws Exception {
        return users.stream().filter(u -> u.getUserID().equals(userID)).findFirst()
                    .orElseThrow(() -> new Exception("User not found."));
    }
    
    private Book getBook(String ISBN) throws Exception {
        return books.stream().filter(b -> b.getISBN().equals(ISBN)).findFirst()
                    .orElseThrow(() -> new Exception("Book not found."));
    }
    
    private void saveLibraryData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            oos.writeObject(books);
            oos.writeObject(users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void loadLibraryData() {
        File file = new File(DATA_FILE);
        if (!file.exists()) return;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            books = (List<Book>) ois.readObject();
            users = (List<User>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}