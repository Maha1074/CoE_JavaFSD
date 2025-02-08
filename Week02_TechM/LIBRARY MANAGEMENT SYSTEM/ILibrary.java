public interface ILibrary {
    void borrowBook(String ISBN, String userID) throws Exception;
    void returnBook(String ISBN, String userID) throws Exception;
    void reserveBook(String ISBN, String userID) throws Exception;
    Book searchBook(String title);
}