import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public abstract class LibrarySystem implements ILibrary {
    protected List<Book> books;
    protected List<User> users;
    protected final ReentrantLock lock = new ReentrantLock();
    
    public abstract void addBook(Book book);
    public abstract void addUser(User user);
}