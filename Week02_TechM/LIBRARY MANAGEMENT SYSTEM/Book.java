import java.io.Serializable;

public class Book implements Serializable {
    private String title;
    private String author;
    private String ISBN;
    private boolean isBorrowed;

    public Book(String title, String author, String ISBN) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.isBorrowed = false;
    }
    
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getISBN() { return ISBN; }
    public boolean isBorrowed() { return isBorrowed; }
    public void setBorrowed(boolean status) { this.isBorrowed = status; }
    
    @Override
    public String toString() {
        return title + " by " + author + " (ISBN: " + ISBN + ")";
    }
}