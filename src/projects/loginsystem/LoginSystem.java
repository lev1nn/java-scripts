package projects.loginsystem;

import java.io.IOException;
import java.util.*;

public class LoginSystem {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileReader db = new FileReader(); // instance from filereader
        String user; // some declarations
        String password;
        int badPasswordCounter = 0; // initialize badpasswordcounter
        int maxBadPasswords = 10; // initialize maxbadpasswords

        do {
            System.out.print("username: ");
            user = scanner.nextLine(); // input -> user
            System.out.println();
        } while (!validUser(user, db, scanner)); // checks if username is valid, else it repeats the step or user can create a new account

        do {
            System.out.print("password: ");
            password = scanner.nextLine(); // input -> password
            System.out.println();

            if (validPassword(user, password, db)) { // checks if password is valid
                System.out.println(ANSI_GREEN + "success, you are logged in " + ANSI_RESET); // success message
                break;
            }
            badPasswordCounter++; // otherwise, it sets the counter one higher
        } while (badPasswordCounter < maxBadPasswords); // while max of bad password isn't reached, it makes the pw query

        if (badPasswordCounter >= maxBadPasswords) { // if the counter is to high, it prints an error message
            System.out.println("failed to log in " + ANSI_RED + "[badPasswordCounter to high]" + ANSI_RESET + " please try again later or contact the administrator ");
            System.exit(0);
        }
    }

    private static boolean validUser(String user, FileReader db, Scanner scanner) {
        if (user == null || user.equals("") || user.matches("[ \t]+")) { // checks if user is empty
            System.out.println("error " + ANSI_RED + "[empty user]" + ANSI_RESET + " please try again"); // -> error message
            System.out.println();
            return false;
        } else if (!db.containsUser(user)) { // checks if user isn't in db
            System.out.println("error " + ANSI_RED + "[user doesn't exist]" + ANSI_RESET + " please try again or type 'new' for create a new user"); // -> error message, asks if user wants to create a new user
            if (scanner.nextLine().equals("new")) {
                try {
                    createUser(user, db, scanner);
                } catch (IOException e) { // exception
                    e.printStackTrace();
                }
            }
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

    private static void createUser(String user, FileReader db, Scanner scanner) throws IOException { // creates new user if user wants to create a new account
        System.out.println();
        System.out.printf("password for user %s: ", user);
        String newUser = (user + "," + scanner.nextLine()); // creates string in format [user,password]
        System.out.println();
        FileReader.FileWriter(newUser); // method to creates new user in db
    }
}
