package projects.fileeditor;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileEditor {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in); // create new input scanner

        System.out.println("Geben Sie den Pfad, an dem Ihr Dokument gespeicher werden soll, im Format ['C:\\...\\'] an: "); // input -> directory //
        String directory = scanner.nextLine();
        System.out.println("");
        while (!directory.matches("[a-zA-Z]:[\\\\\\/](?:[a-zA-Z0-9]+[\\\\\\/])*")) { // checks if path is valid an if its not, you can enter a new path name
            System.out.println("Unglültiger Dateipfad, bitte geben Sie einen neuen Pfad im Format ['C:\\...\\'] an oder beenden Sie das Programm mit 'E': ");
            directory = scanner.nextLine();
            System.out.println("");
            if (directory.equals("E") || directory.equals("e")) {
                System.exit(0);
            }
        }
        System.out.println("Geben Sie an welchen Namen Ihr Textfile haben sollte im Format ['FileName'] ohne .txt: "); // input -> filename
        String fileName = scanner.nextLine();
        String completePath = directory + fileName + ".txt"; // completePath = complete path + filename.txt
        System.out.println("");

        cleanUpFiles(completePath, directory); // method deletes file when it already exists
        createFile(directory, fileName, completePath); // method creates the text file at the specified path with the specified name

        System.out.println("Geben Sie jetzt Ihren Text ein: "); // input -> content of the file
        String fileContent = scanner.nextLine();
        writeFile(fileContent, completePath); // method writes the input into the created file

        System.out.println("");
        System.out.println("Aufgabe wurde erfolgreich abgeschlossen!"); // the system says success
    }

    public static void cleanUpFiles(String completePath, String directory) {
        Scanner scanner = new Scanner(System.in); // create new input scanner

        // TODO ask if user wants to delete file when it already exists or if user wants to name the file otherwise

        // if (completePath.exists() && !completePath.isDirectory()) {
            // System.out.println("Das File existiert bereits, wollen Sie es löschen? [y/n] ");
            // String wantsToDelete = scanner.nextLine();
            // if (wantsToDelete.equals("y") || wantsToDelete.equals("Y")) {
                File targetFile = new File(completePath);
                targetFile.delete();
            // }
        // }
    }

    private static void createFile(String directory, String fileName, String completePath) throws IOException {
        Path newFilePath = Paths.get(completePath);
        Files.createFile(newFilePath);

        System.out.printf("Das File mit dem Namen '%s' wurde im Verzeichnis '%s' erstellt! %n", fileName, directory);
        System.out.printf("Der Pfad ist nun '%s'%n", completePath);
        System.out.println("");
    }

    private static void writeFile(String fileContent, String completePath) throws FileNotFoundException {
        PrintStream content = new PrintStream(completePath);
        content.println(fileContent);
    }
}

// help:
// https://www.baeldung.com/java-how-to-create-a-file
// https://ethz.ch/content/dam/ethz/special-interest/infk/inst-cs/lst-dam/documents/Education/Classes/Fall2018/0027_Intro/Slides/18E1016_2.pdf
// https://www.delftstack.com/de/howto/java/java-check-if-a-file-exists/#:~:text=io.-,File%20%2C%20um%20zu%20pr%C3%BCfen%2C%20ob%20eine%20Datei%20in%20Java%20existiert,ob%20die%20angegebene%20Datei%20existiert.
// https://regex101.com/
