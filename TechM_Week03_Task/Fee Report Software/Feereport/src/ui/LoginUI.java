package ui;

import java.util.Scanner;
import model.Accountant;
import model.Admin;
import service.AccountantService;
import service.AdminService;

public class LoginUI {
    public static void loginMenu() {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("===== Fee Report System =====");
            System.out.println("1. Admin Login");
            System.out.println("2. Accountant Login");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    adminLogin();
                    break;
                case 2:
                    accountantLogin();
                    break;
                case 3:
                    System.out.println("Exiting... Thank you!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void adminLogin() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Admin Username: ");
        String username = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        Admin admin = AdminService.validateAdmin(username, password);
        if (admin != null) {
            System.out.println("Login Successful! Welcome Admin.");
            AdminUI.adminMenu(); // Ensure this method exists
        } else {
            System.out.println("Invalid credentials. Try again.");
        }
    }

    private static void accountantLogin() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Accountant Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        Accountant accountant = AccountantService.getAccountant(email, password); // FIXED
        if (accountant != null) {
            System.out.println("Login Successful! Welcome Accountant.");
            AccountantUI.accountantMenu(); // FIXED: Now exists in AccountantUI.java
        } else {
            System.out.println("Invalid credentials. Try again.");
        }
    }
}
