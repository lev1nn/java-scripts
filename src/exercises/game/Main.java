package game;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("name from player1 ");
        String name1 = scanner.nextLine();
        System.out.println("");

        System.out.println("name from player2 ");
        String name2 = scanner.nextLine();
        System.out.println("");

        Character player1 = new Character(name1, 100, 25);
        Character player2 = new Character(name2, 100, 25);

        Fight fight = new Fight(player1, player2);

        fight.fight();
    }
}
