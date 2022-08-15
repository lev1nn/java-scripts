package controlstructures;

import java.util.Scanner;

public class StarExercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welche Darstellung der Zeichen wollen Sie? ");
        System.out.println("1 -> growing");
        System.out.println("2 -> shrinking");
        System.out.println("3 -> fancy");
        System.out.println("");
        System.out.println("Ihre Eingabe: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> growing();
            case 2 -> shrinking();
            case 3 -> fancy();
            default -> System.out.println("Ungültige Eingabe, bitte erneut versuchen ");
        }
    }

    private static void growing() {
        Scanner scanner = new Scanner(System.in);

        int objects, rows;
        int x, y, z;
        String icon = "*";

        System.out.println("Anzahl Objekte: ");
        objects = scanner.nextInt();
        System.out.println("Anzahl Reihen: ");
        rows = scanner.nextInt();
        System.out.println("");

        for (z = 1; z <= objects; z++) {
            for (x = 1; x <= rows; x++) {
                for (y = 1; y <= x; y++) {
                    System.out.print(icon);
                }
                System.out.println("");
            }
        // Objects objects1 = new Objects(rows);
        // objects1.triangle();
        }
    }

    private static void shrinking() {
        Scanner scanner = new Scanner(System.in);

        int objects, rows;
        int x, y, z;
        String icon = "*";

        System.out.println("Anzahl Objekte: ");
        objects = scanner.nextInt();
        System.out.println("Anzahl Reihen: ");
        rows = scanner.nextInt();
        System.out.println("");

        for (z = 1; z <= objects; z++) {
            for (x = 1; x <= rows; x++) {
                for (y = rows - x + 1; y > 0; y--) {
                    System.out.print(icon);
                }
                System.out.println("");
            }
        // Objects objects1 = new Objects(rows);
        // objects1.otherTriangle();
        }
    }

    private static void fancy() {
        Scanner scanner = new Scanner(System.in);

        int objects, rows;
        int x, y, z;
        String icon = "*";

        System.out.println("Anzahl Objekte: ");
        objects = scanner.nextInt();
        System.out.println("Anzahl Reihen: ");
        rows = scanner.nextInt();
        System.out.println("");

        for (z = 1; z <= objects; z++) {
            for (x = 1; x <= rows; x++) {
                for (y = 1; y <= x; y++) {
                    System.out.print(icon);
                }
                System.out.println("");
            }
            for (x = 1; x < rows; x++) {
                rows --;
                for (y = rows - x + 1; y > 0; y--) {
                    System.out.print(icon);
                } rows ++;
                System.out.println("");
            }
        // Objects objects1 = new Objects(rows);
        // objects1.fancyTriangle();
        }
    }
}
