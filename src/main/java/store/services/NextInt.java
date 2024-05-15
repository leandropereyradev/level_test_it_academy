package store.services;

import java.util.Scanner;

public class NextInt {
    public static int getNextInt(@org.jetbrains.annotations.NotNull Scanner scanner) {
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.println("Invalid input. Please enter a valid integer.");
        }

        return scanner.nextInt();
    }
}
