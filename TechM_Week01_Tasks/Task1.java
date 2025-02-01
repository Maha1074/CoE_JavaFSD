import java.util.*;

class Task {
    String id;
    String description;
    int priority;

    public Task(String id, String description, int priority) {
        this.id = id;
        this.description = description;
        this.priority = priority;
    }

    public String toString() {
        return "[ID: " + id + ", Description: " + description + ", Priority: " + priority + "]";
    }
}

class Task1 {
    private PriorityQueue<Task> taskQueue;
    private Map<String, Task> taskMap;

    public Task1() {
        taskQueue = new PriorityQueue<>(Comparator.comparingInt(task -> -task.priority));
        taskMap = new HashMap<>();
    }

    public void addTask(String id, String description, int priority) {
        Task task = new Task(id, description, priority);
        taskQueue.add(task);
        taskMap.put(id, task);
    }

    public void removeTask(String id) {
        Task task = taskMap.remove(id);
        if (task != null) {
            taskQueue.remove(task);
            System.out.println("Task removed successfully.");
        } else {
            System.out.println("Task ID not found.");
        }
    }

    public Task getHighestPriorityTask() {
        return taskQueue.peek();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Task1 manager = new Task1();
        
        while (true) {
            System.out.println("\n1. Add Task\n2. Remove Task\n3. View Highest Priority Task\n4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter Task ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Task Description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter Task Priority (higher number = higher priority): ");
                    int priority = scanner.nextInt();
                    scanner.nextLine();
                    manager.addTask(id, description, priority);
                    System.out.println("Task added successfully.");
                    break;
                case 2:
                    System.out.print("Enter Task ID to remove: ");
                    String removeId = scanner.nextLine();
                    manager.removeTask(removeId);
                    break;
                case 3:
                    Task highest = manager.getHighestPriorityTask();
                    System.out.println(highest != null ? "Highest Priority Task: " + highest : "No tasks available.");
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}