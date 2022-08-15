package controlstructures;;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class InterestCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Betrag in CHF: ");
        double amountOfMoney = input.nextDouble();
        System.out.println("Zins in %: ");
        double interest = input.nextDouble();;
        System.out.println("Laufzeit in Jahre: ");
        int runtime = input.nextInt();
        System.out.println("");

        for (int x = 1; x <= runtime; x++) {
            amountOfMoney = amountOfMoney + ((amountOfMoney / 100) * interest);
            BigDecimal round = new BigDecimal(amountOfMoney).setScale(2, RoundingMode.HALF_UP);
            System.out.println("Jahr " + x + ": " + round);
        }
    }
}
