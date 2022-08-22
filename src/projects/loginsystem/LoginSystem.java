package projects.loginsystem;

import java.util.*;

public class LoginSystem {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileReader db = new FileReader(); // instance from FileReader
        String user;
        String password;
        int badPasswordCounter = 0;
        int maxBadPasswords = 10;

        do {
            System.out.print("username: "); // TODO let user create new acc if he hasn't one
            user = scanner.nextLine(); // input -> user
            System.out.println();
        } while (!validUser(user, db)); // checks if username is valid, else it repeats the step

        do {
            System.out.print("password: ");
            password = scanner.nextLine(); // input -> password
            System.out.println();

            if (validPassword(user, password, db)) { // checks if password is valid
                System.out.println(ANSI_GREEN + "success, you are logged in " + ANSI_RESET); // success message
                break;
            }
            badPasswordCounter++; // otherwise, it sets the counter one higher
        } while (badPasswordCounter < maxBadPasswords);

        if (badPasswordCounter >= maxBadPasswords) { // if the counter is to high, it prints a error message
            System.out.println("failed to log in " + ANSI_RED + "[badPasswordCounter to high]" + ANSI_RESET + " please try again later or contact the administrator ");
            System.exit(0);
        }
    }

    private static boolean validUser(String user, FileReader db) {
        if (user == null || user.equals("") || user.matches("[ \t]+")) { // checks if user is empty
            System.out.println("error " + ANSI_RED + "[empty user]" + ANSI_RESET + " please try again"); // -> error message
            System.out.println();
            return false;
        } else if (!db.containsUser(user)) { // checks if user isn't in db
            System.out.println("error " + ANSI_RED + "[user doesn't exist]" + ANSI_RESET + " please try again"); // -> error message
            System.out.println();
            return false;
        } else {
            return true;
        }
    }

    public static boolean validPassword(String user, String password, FileReader db) {
        String pwFromDB = db.getPasswordForUser(user);

        if (pwFromDB == null) { // if pw is null -> error message
            System.out.println("failed to log in [problem in database] please try again ");
            System.out.println();
            return false;
        } else if (password == null || password.equals("") || password.matches("[ \t]+")) { // if pw is empty -> error message
            System.out.println("failed to log in " + ANSI_RED + "[empty password]" + ANSI_RESET + " please try again ");
            System.out.println();
            return false;
        } else if (pwFromDB.equals(password)) { // if pw is correct -> error message
            return true;
        } else if (!pwFromDB.equals(password)) { // if pw is incorrect -> error message
            System.out.println("failed to log in " + ANSI_RED + "[invalid password]" + ANSI_RESET + " please try again ");
            System.out.println();
            return false;
        } else { // else unknown error message
            System.out.println("failed to log in " + ANSI_RED + "[unknown error]" + ANSI_RESET + " please try again ");
            System.out.println();
            return false;
        }
    }
}


