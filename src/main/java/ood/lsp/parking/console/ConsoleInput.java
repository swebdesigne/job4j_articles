package ood.lsp.parking.console;

import java.util.Scanner;

public class ConsoleInput {
    private static Scanner scanner = new Scanner(System.in);

    public static String askStr() {
        return scanner.nextLine();
    }

    public static int askInt(String input) {
        return Integer.parseInt(input);
    }

    public static boolean validate(String input, int size) {
        try {
            int ask = Integer.parseInt(input);
            if (ask < 0 || ask >= size) {
                System.out.println("Wrong input, you can select: 0 .. " + (size - 1));
                return false;
            }
        } catch (NumberFormatException e) {
            System.out.println("Wrong input, input must be a number from 0 .. " + (size - 1));
            return false;
        }
        return true;
    }

    public static void stop() {
        scanner.close();
    }
}
