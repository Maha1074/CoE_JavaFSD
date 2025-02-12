package ui;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("===== Fee Report System =====");
        System.out.println("1. Admin Login");
        System.out.println("2. Add Accountant");
        System.out.print("Enter choice: ");
        
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (choice == 1) {
            AdminUI.login();
        } else if (choice == 2) {
            AccountantUI.addAccountant(); // Call the correct method
        } else {
            System.out.println("Invalid choice! Exiting...");
        }
        
        scanner.close();
    }
}