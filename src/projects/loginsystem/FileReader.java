package projects.loginsystem;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class FileReader {
    private Map<String, String> userDB = new HashMap<>(); // creates hashmap as "database"
    private static final String FILE_PATH = "C:\Users\Levin\OneDrive\Desktop\Levin\Programmieren\Privat\src\projects\loginsystem\Users.txt"; // path textfile with usernames and passwords

    public FileReader() {
        try (Stream<String> lines = Files.lines(Paths.get(FILE_PATH))) { // reads textfile and writes into hashmap
            lines.filter(line -> line.contains(",")) // comma separates username from password
                    .forEach(line -> {
                        String[] keyValuePair = line.split(",", 2); // separates with comma
                        String key = keyValuePair[0]; // string1 -> key -> username
                        String value = keyValuePair[1]; // string2 -> value -> password
                        userDB.put(key, value); // -> puts both strings into hashmap
                    });
        } catch (IOException e) { // exception
            e.printStackTrace();
        }
    }

    public static void FileWriter(String newUser) throws IOException {
        FileWriter fileWriter = new FileWriter(FILE_PATH, true); // creates new fileWriter
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write("\n" + newUser); // creates new user in textfile db users
        bufferedWriter.close();

        System.out.println("user has been created, please restart and try to log in "); // success message
        System.exit(0);
    }

    public boolean containsUser(String user) { // checks if the entered user is in the db
        return userDB.containsKey(user);
    }

    public String getPasswordForUser(String user) { // checks if the entered password is correct
        if (containsUser(user)) { 
            return userDB.get(user);
        } else {
            return null;
        }
    }
}
