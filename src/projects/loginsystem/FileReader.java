package projects.loginsystem;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class FileReader {
    private Map<String, String> userDB = new HashMap<>();
    private final String FILE_PATH = "C:\\Users\\Levin\\OneDrive\\Desktop\\Levin\\Programmieren\\Privat\\src\\projects\\loginsystem\\Users.txt";

    public FileReader() {
        try (Stream<String> lines = Files.lines(Paths.get(FILE_PATH))) {
            lines.filter(line -> line.contains(","))
                    .forEach(line -> {
                        String[] keyValuePair = line.split(",", 2);
                        String key = keyValuePair[0];
                        String value = keyValuePair[1];
                        userDB.put(key, value);
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean containsUser(String user) {
        return userDB.containsKey(user);
    }

    public String getPasswordForUser(String user) {
        if (containsUser(user)) {
            return userDB.get(user);
        } else {
            return null;
        }
    }
}
