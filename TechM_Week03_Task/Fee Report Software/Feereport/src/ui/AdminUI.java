package ui;

import dao.AccountantDao;
import java.util.List;
import java.util.Scanner;
import model.Accountant;

public class AdminUI {
    public static void login() { // Admin Login
        Scanner scanner = new Scanner(System.in);
        System.out.println("===== Admin Login =====");

        System.out.print("Enter Username: ");
        String username = scanner.nextLine();

        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        // Dummy authentication for now (Replace with real authentication later)
        if ("admin".equals(username) && "admin123".equals(password)) {
            System.out.println("Admin login successful!");
            adminMenu();
        } else {
            System.out.println("Invalid credentials! Try again.");
        }
    }

    public static void adminMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n===== Admin Panel =====");
            System.out.println("1. Add Accountant");
            System.out.println("2. View Accountants");
            System.out.println("3. Delete Accountant");
            System.out.println("4. Logout");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addAccountant(scanner);
                    break;
                case 2:
                    viewAccountants();
                    break;
                case 3:
                    deleteAccountant(scanner);
                    break;
                case 4:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    private static void addAccountant(Scanner scanner) {
        System.out.println("\n===== Add Accountant =====");
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter Phone: ");
        String phone = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        Accountant accountant = new Accountant(0, name, email, phone, password); // ID auto-generated
        if (AccountantDao.addAccountant(accountant)) {
            System.out.println("Accountant added successfully!");
        } else {
            System.out.println("Failed to add accountant.");
        }
    }

    private static void viewAccountants() {
        List<Accountant> accountants = AccountantDao.getAllAccountants();
        System.out.println("\n===== Accountant List =====");
        for (Accountant acc : accountants) {
            System.out.println("ID: " + acc.getId() + ", Name: " + acc.getName() +
                    ", Email: " + acc.getEmail() + ", Phone: " + acc.getPhone());
        }
    }

    private static void deleteAccountant(Scanner scanner) {
        System.out.print("Enter Accountant ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (AccountantDao.deleteAccountant(id)) {
            System.out.println("Accountant deleted successfully!");
        } else {
            System.out.println("Failed to delete accountant. Please check the ID.");
        }
    }
}
