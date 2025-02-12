package ui;

import java.util.Scanner;
import model.Accountant;
import service.AccountantService;

public class AccountantUI {
    public static void addAccountant() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Accountant Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter Phone: ");
        String phone = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        Accountant accountant = new Accountant(0, name, email, phone, password);
        boolean status = AccountantService.addNewAccountant(accountant);
        if (status) {
            System.out.println("Accountant added successfully!");
        } else {
            System.out.println("Error adding accountant.");
        }

        scanner.close(); 
    }
    public static void accountantMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("===== Accountant Menu =====");
            System.out.println("1. View Students");
            System.out.println("2. Add Fee Details");
            System.out.println("3. Logout");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.println("Displaying students...");
                    break;
                case 2:
                    System.out.println("Adding fee details...");
                    break;
                case 3:
                    System.out.println("Logging out...");
                    scanner.close(); 
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
    public static void main(String[] args) {
        accountantMenu();
    }
}