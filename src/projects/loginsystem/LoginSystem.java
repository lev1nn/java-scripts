package projects.loginsystem;

import java.util.*;

public class LoginSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        FileReader db = new FileReader();

        System.out.print("Username: "); // TODO let user create new acc if he hasn't one
        String user = scanner.nextLine();
        System.out.println(); // TODO check if user exists
        System.out.print("Password: ");
        String password = scanner.nextLine();
        System.out.println();

        if (validPassword(user, password, db)) {
            System.out.println("success, you are logged in ");
        } else {
            System.out.println("failed to log in, please try again "); // TODO more accurate error messages
        }
    }

    public static boolean validPassword(String user, String password, FileReader db) {
        String pwFromDB = db.getPasswordForUser(user);

        if (pwFromDB != null) {
            return pwFromDB.equals(password);
        } else {
            return false;
        }

        // return password.equals(pwFromDB);
    }
}
