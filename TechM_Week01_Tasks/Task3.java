import java.util.Scanner;

public class Task3 {
    public static void processInput() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter a number: ");
            double num = sc.nextDouble();
            double reciprocal = 1 / num;
            System.out.println("Reciprocal: " + reciprocal);
        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero is not allowed.");
        } catch (Exception e) {
            System.out.println("Invalid input! Please enter a valid number.");
        } finally {
            sc.close();
        }
    }

    public static void main(String[] args) {
        processInput();
    }
}
