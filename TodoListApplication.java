import java.util.ArrayList;
import java.util.Scanner;

class TodoList {
    private ArrayList<String> tasks;

    public TodoList() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(String task) {
        tasks.add(task);
    }

    public void deleteTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
        } else {
            System.out.println("Invalid task index.");
        }
    }

    public void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
        } else {
            System.out.println("Tasks:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    public void markTaskAsComplete(int index) {
        if (index >= 0 && index < tasks.size()) {
            String task = tasks.get(index);
            tasks.set(index, "[X] " + task);
        } else {
            System.out.println("Invalid task index.");
        }
    }
}

public class TodoListApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TodoList todoList = new TodoList();

        int choice;
        do {
            System.out.println("Todo List Application");
            System.out.println("1. Add Task");
            System.out.println("2. Delete Task");
            System.out.println("3. Display Tasks");
            System.out.println("4. Mark Task as Complete");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter task to add: ");
                    scanner.nextLine(); // Consume newline
                    String newTask = scanner.nextLine();
                    todoList.addTask(newTask);
                    break;
                case 2:
                    System.out.print("Enter index of task to delete: ");
                    int deleteIndex = scanner.nextInt();
                    todoList.deleteTask(deleteIndex - 1);
                    break;
                case 3:
                    todoList.displayTasks();
                    break;
                case 4:
                    System.out.print("Enter index of task to mark as complete: ");
                    int completeIndex = scanner.nextInt();
                    todoList.markTaskAsComplete(completeIndex - 1);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 0);

        scanner.close();
    }
}
