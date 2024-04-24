package vink.mqttshield.core;

import java.util.Scanner;
public class InputHandler {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command;

        System.out.println("Welcome to the Command Executor!");
        System.out.println("Enter 'help' for usage and 'exit' to quit.");

        do {
            System.out.print("> ");
            command = scanner.nextLine();
            if (command.equalsIgnoreCase("exit")) {
                System.out.println("Exiting...");
                break;
            }

            String[] commandParts = command.split("\\s+");
            String commandName = commandParts[0];
            String[] commandArgs = commandParts.length > 1 ? new String[commandParts.length - 1] : new String[0];

            if (commandArgs.length > 0) {
                System.arraycopy(commandParts, 1, commandArgs, 0, commandArgs.length);
            }

            switch (commandName.toLowerCase()) {
                case "exit":
                    System.out.println("Exiting...");
                    break;
                case "hello":
                    System.out.println("Hello, world!");
                    break;
                case "help":
                    System.out.println("Available commands:");
                    System.out.println("  exit: Exit the program");
                    System.out.println("  hello: Print 'Hello, world!'");
                    System.out.println("  example: Print 'Argument: ' followed by the argument value");
                    break;
                case "example":
                    if (commandArgs.length == 1) {
                        System.out.println("Argument: " + commandArgs[0] + "!");
                    } else {
                        System.out.println("Invalid command arguments.");
                    }
                    break;                    
                default:
                    System.out.println("Unknown command: " + command);
                    break;
            }
        } while (!command.equalsIgnoreCase("exit"));

        scanner.close();
    }
}
