package views;

import java.util.Scanner;

public class UserView {
    // ANSI color codes for terminal styling
    private static final String BLUE = "\u001B[34m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String CYAN = "\u001B[36m";
    private static final String RESET = "\u001B[0m";
    //
    public void showWelcomeScreen() {
        // Main header
        System.out.println(BLUE+"=".repeat(50)+ RESET);
        System.out.println(BLUE+"""
                  _____              _    _   __       \s
                 / ____|            | |  (_) / _|      \s
                | |      __ _  _ __ | |_  _ | |_  _   _\s
                | |     / _` || '__|| __|| ||  _|| | | |
                | |____| (_| || |   | |_ | || |  | |_| |
                 \\_____|\\__,_||_|    \\__||_||_|   \\__, |
                                                   __/ |
                                                  |___/\s
                """+ RESET);
        System.out.println(BLUE+"=".repeat(50)+ RESET);
        // Menu options with boxes
        System.out.println();
        System.out.println(YELLOW + "+===================+" + "     " + "+===================+" + RESET);
        System.out.println(YELLOW + "|      1.LOGIN      |" + "     " + "|    2.REGISTER     |" + RESET);
        System.out.println(YELLOW + "+===================+" + "     " + "+===================+" + RESET);
        System.out.println();
        System.out.println("Enter your choice (1-2): ");
    }
    public void showSelectedOption() {
        int opt = new Scanner(System.in).nextInt();
        switch (opt) {
            case 1:
                System.out.println(GREEN + "You selected: Login" + RESET);
                break;
            case 2:

                break;
            default:
                System.out.println(CYAN + "Invalid option!" + RESET);
        }
    }
}