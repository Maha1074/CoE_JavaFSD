import java.io.*;
import java.util.*;

public class Task4 {
    private static List<String> users = new ArrayList<>();

    public static void addUser(String name, String email) {
        users.add(name + "," + email);
    }

    public static void saveUsersToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (String user : users) {
                writer.write(user);
                writer.newLine();
            }
            System.out.println("Users saved to file successfully.");
        } catch (IOException e) {
            System.out.println("Error saving users: " + e.getMessage());
        }
    }

    public static void loadUsersFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            System.out.println("User Details:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error loading users: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter email: ");
        String email = sc.nextLine();
        addUser(name, email);

        System.out.print("Enter filename to save users: ");
        String filename = sc.next();
        saveUsersToFile(filename);

        System.out.print("Enter filename to load users: ");
        filename = sc.next();
        loadUsersFromFile(filename);
        
        sc.close();
    }
}
