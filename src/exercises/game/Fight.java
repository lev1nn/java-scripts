package game;

public class Fight {
    private Character player1;
    private Character player2;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public Fight(Character player1, Character player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void fight() {
        String line = "\n--------------------\n";

        System.out.printf("%s vs %s%n", player1.getName(), player2.getName());
        System.out.println(line);

        while (player1.getHp() > 0 && player2.getHp() > 0) {
            int attack1 = player1.attack();
            player1.setHp(player1.getHp());
            if (player2.getHp() <= attack1) {
                attack1 = player2.getHp();
            }
            player2.setHp(player2.getHp() - attack1);
            System.out.printf(ANSI_GREEN + "%s attacks" + ANSI_RESET + " - %s loses %d hp%n", player1.getName(), player2.getName(), attack1);
            System.out.printf("%s: hp = %d%n", player1.getName(), player1.getHp());
            if (attack1 != 0) {
                System.out.printf("%s: " + ANSI_RED + "hp = %d%n" + ANSI_RESET, player2.getName(), player2.getHp());
            } else {
                System.out.printf("%s: hp = %d%n", player2.getName(), player2.getHp());
            }
            System.out.println(line);

            if (player2.getHp() > 0) {
                int attack2 = player2.attack();
                player2.setHp(player2.getHp());
                if (player1.getHp() <= attack2) {
                    attack2 = player1.getHp();
                }
                player1.setHp(player1.getHp() - attack2);
                System.out.printf(ANSI_GREEN + "%s attacks" + ANSI_RESET + " - %s loses %d hp%n", player2.getName(), player1.getName(), attack2);
                System.out.printf("%s: hp = %d%n", player2.getName(), player2.getHp());
                if (attack2 != 0) {
                    System.out.printf("%s: " + ANSI_RED + "hp = %d%n" + ANSI_RESET, player1.getName(), player1.getHp());
                } else {
                    System.out.printf("%s: hp = %d%n", player1.getName(), player1.getHp());
                }
                System.out.println(line);
            } else {
                break;
            }
        }
        if (player1.getHp() > 0) {
            System.out.printf(ANSI_GREEN + "%s wins with %d hp left! %n" + ANSI_RESET, player1.getName(), player1.getHp());
        } else {
            System.out.printf(ANSI_GREEN + "%s wins with %d hp left! %n" + ANSI_RESET, player2.getName(), player2.getHp());
        }
    }
}
