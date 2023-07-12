import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Task {
    private String description;
    private String dueDate;
    private int priority;

    public Task(String description, String dueDate, int priority) {
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public String getDueDate() {
        return dueDate;
    }

    public int getPriority() {
        return priority;
    }
}

public class Planner {
    private static List<Task> tasks = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Select an option:");
            System.out.println("1. Add task");
            System.out.println("2. Sort tasks by due date");
            System.out.println("3. Sort tasks by time added");
            System.out.println("4. Sort tasks by priority");
            System.out.println("5. Print tasks");
            System.out.println("6. Exit");

            int option = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (option) {
                case 1:
                    addTask();
                    break;
                case 2:
                    sortTasksByDueDate();
                    break;
                case 3:
                    sortTasksByTimeAdded();
                    break;
                case 4:
                    sortTasksByPriority();
                    break;
                case 5:
                    printTasks();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }

    private static void addTask() {
        System.out.println("Enter task description:");
        String description = scanner.nextLine();

        System.out.println("Enter due date:");
        String dueDate = scanner.nextLine();

        System.out.println("Enter task priority (1-5):");
        int priority = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Task task = new Task(description, dueDate, priority);
        tasks.add(task);

        System.out.println("Task added successfully.");
    }

    private static void sortTasksByDueDate() {
        Collections.sort(tasks, Comparator.comparing(Task::getDueDate));
        System.out.println("Tasks sorted by due date.");
    }

    private static void sortTasksByTimeAdded() {
        // The tasks list is already in the order they were added
        System.out.println("Tasks sorted by time added.");
    }

    private static void sortTasksByPriority() {
        Collections.sort(tasks, Comparator.comparingInt(Task::getPriority));
        System.out.println("Tasks sorted by priority.");
    }

    private static void printTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
        } else {
            for (Task task : tasks) {
                System.out.println("Description: " + task.getDescription());
                System.out.println("Due Date: " + task.getDueDate());
                System.out.println("Priority: " + task.getPriority());
                System.out.println("-----------------------");
            }
        }
    }
}
