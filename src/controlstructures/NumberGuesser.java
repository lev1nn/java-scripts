package controlstructures;

import java.util.Random;
import java.util.Scanner;

public class NumberGuesser {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        boolean wantToPlay = true;

        for (int amountOfGames = 1; wantToPlay; amountOfGames++) {
            System.out.println("");
            System.out.println("Willkommen zu NumberGuesser :D");
            System.out.println("Geben Sie einen Höchstwert ein: ");
            int max = input.nextInt();
            int randomNumber = random.nextInt(max) + 1;
            System.out.println("");
            System.out.println("Erraten Sie die ganze Zahl, an die ich denke, welche zwischen 1 und " + max + " liegt. ");
            System.out.println("Eingabe: ");
            int guess = input.nextInt();
            int guesses = 1;

            while (guess != randomNumber) {
                if (guess > randomNumber) {
                    System.out.println("Die Zahl ist kleiner ");
                } else {
                    System.out.println("Die Zahl ist grösser ");
                }
                System.out.println("Eingabe: ");
                guess = input.nextInt();
                guesses++;
            }

            System.out.println("Richtig, die Zahl war " + randomNumber + "! Sie haben " + guesses + " Versuche gebraucht. ");
            System.out.println("Wollen Sie nochmal spielen? (y/n) ");
            input.nextLine();
            String response = input.nextLine();

            if ("n".equals(response)) {
                wantToPlay = false;
                System.out.println("Okay, Sie haben " + amountOfGames + " mal gespielt");
            }
        }
    }
}
