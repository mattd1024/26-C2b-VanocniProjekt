package game;

import java.util.Scanner;

/**
 * Trida Console obsahuje pomocne metody pro praci s konzoli
 */
public class Console {
    private static Scanner scanner = new Scanner(System.in);

    /**
     * Pauzne konzoli dokud hrac nevlozi cokoliv
     */
    public static void printEnter() {
        printColorMessage("<Stiskni cokoliv pro pokracovani>", Colors.GREEN);
        scanner.nextLine();
        printSpace();
    }

    /**
     * Vezme input z konzole a vraci string
     * @return String
     */
    public static String getInputFromUser() {
        return scanner.nextLine();
    }

    /**
     * Vyprinti error do konzole s cervenou barvou
     * @param message String zprava
     */
    public static void printError(String message) {
        System.out.println(Colors.RED + "ERROR >>>> " + message + Colors.RESET);
        printEnter();
        printSpace();
    }

    /**
     * Vyprinti zabarvenou zpravu do konzole
     * @param message String zprava
     * @param color String barva dle Colors.BARVA (BARVA v anglictine)
     */
    public static void printColorMessage(String message, String color) {
        System.out.println(color + message + Colors.RESET);
    }

    /**
     * Vyprinti do konzole spoustu prazdneho mista pro vycisteni
     */
    public static void printSpace() {
        for (int i = 0; i < 5; i++) {
            System.out.println();
        }
    }


}
