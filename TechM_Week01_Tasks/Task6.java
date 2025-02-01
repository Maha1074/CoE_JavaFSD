import java.util.Scanner;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Task6 {
    public static boolean hasCycle(Node head) {
        if (head == null) return false;
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        head.next = second;
        second.next = third;

        System.out.print("Do you want to create a cycle? (yes/no): ");
        if (sc.next().equalsIgnoreCase("yes")) {
            third.next = second;
        }

        System.out.println("Does the linked list have a cycle? " + hasCycle(head));
        sc.close();
    }
}
