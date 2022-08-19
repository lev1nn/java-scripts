package projects.loginsystem;

import java.util.*;

public class LoginSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        FileReader db = new FileReader();

        System.out.print("username: "); // TODO let user create new acc if he hasn't one
        String user = scanner.nextLine();
        System.out.println();
        validUser(user, db);

        System.out.print("password: ");
        String password = scanner.nextLine();
        System.out.println();

        if (validPassword(user, password, db)) {
            System.out.println("success, you are logged in ");
        }
    }

    private static void validUser(String user, FileReader db) {
        if (user == null || user.equals("") || user.matches("[ \t]+")) {
            System.out.println("empty user, please try again");
            System.exit(0);
        } else if (!db.containsUser(user)) {
            System.out.println("user does not exist, please try again ");
            System.exit(0);
        }
    }

    public static boolean validPassword(String user, String password, FileReader db) {
        String pwFromDB = db.getPasswordForUser(user);

        if (pwFromDB == null) {
            System.out.println("failed to log in [problem in database] please try again ");
            return false;
        } else if (password == null || password.equals("") || password.matches("[ \t]+")) {
            System.out.println("failed to log in [empty password] please try again ");
            return false;
        } else if (pwFromDB.equals(password)) {
            return true;
        } else if (!pwFromDB.equals(password)) {
            System.out.println("failed to log in [invalid password] please try again ");
            return false;
        } else {
            System.out.println("failed to log in [unknown error] please try again ");
            return false;
        }
    }
}


