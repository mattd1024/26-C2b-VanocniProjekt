package game;

import java.util.Scanner;

/**
 * Trida Console obsahuje pomocne metody pro praci s konzoli
 */
public class Console {
    private static Scanner scanner = new Scanner(System.in);

    public static void printEnter() {
        System.out.println("Stiskni cokoliv pro pokracovani");
        scanner.nextLine();
    }

    public static String getInputFromUser() {
        return scanner.nextLine();
    }
}
