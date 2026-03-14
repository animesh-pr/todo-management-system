package com.todo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.todo.model.Todo;

@SuppressWarnings("java:S106")
public class Main {

    private static final List<Todo> todos = new ArrayList<>();
    private static final String ENTER_ID = "Enter ID:";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Todo Application");

        selectDatabase(scanner);

        while (true) {

            showMenu();

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> createTodo(scanner);
                case 2 -> getTodo(scanner);
                case 3 -> updateTodo(scanner);
                case 4 -> deleteTodo(scanner);
                case 5 -> showAllTodos();
                case 6 -> {
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid option");
            }
        }
    }

    private static void selectDatabase(Scanner scanner) {

        System.out.println("\nSelect Database:");
        System.out.println("1. MySQL");
        System.out.println("2. MongoDB");
        System.out.println("3. PostgreSQL");

        int dbChoice = scanner.nextInt();
        scanner.nextLine();

        switch (dbChoice) {
            case 1 -> System.out.println("Database selected: mysql");
            case 2 -> System.out.println("Database selected: mongodb");
            default -> System.out.println("Database selected: postgresql");
        }
    }

    private static void showMenu() {

        System.out.println("\n1 Create");
        System.out.println("2 Get");
        System.out.println("3 Update");
        System.out.println("4 Delete");
        System.out.println("5 Show All");
        System.out.println("6 Exit");
    }

    private static void createTodo(Scanner scanner) {

        System.out.println(ENTER_ID);
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter Title:");
        String title = scanner.nextLine();

        System.out.println("Enter Description:");
        String desc = scanner.nextLine();

        Todo todo = new Todo(String.valueOf(id), title, desc, false);
        todos.add(todo);

        System.out.println("Todo added.");
    }

    private static void getTodo(Scanner scanner) {

        System.out.println(ENTER_ID);
        int searchId = scanner.nextInt();

        for (Todo t : todos) {
            if (t.getId().equals(String.valueOf(searchId))) {
                System.out.println(t);
            }
        }
    }

    private static void updateTodo(Scanner scanner) {

        System.out.println(ENTER_ID);
        int updateId = scanner.nextInt();
        scanner.nextLine();

        for (Todo t : todos) {
            if (t.getId().equals(String.valueOf(updateId))) {
                System.out.println("Enter new title:");
                t.setTitle(scanner.nextLine());
            }
        }
    }

    private static void deleteTodo(Scanner scanner) {

        System.out.println(ENTER_ID);
        int deleteId = scanner.nextInt();

        todos.removeIf(t -> t.getId().equals(String.valueOf(deleteId)));

        System.out.println("Deleted.");
    }

    private static void showAllTodos() {

    if (todos.isEmpty()) {
        System.out.println("No todos available.");
        return;
    }

    for (Todo t : todos) {
        System.out.println(t);
    }
    }
}