package controlstructures;

public class Objects {
    private String icon;
    private int counter;

    public Objects (int lines) {
        counter = lines;
        this.icon = "*";
    }

    public void triangle() {
        for (int x = 1; x <= counter; x++) {
            for (int y = 1; y <= x; y++) {
                System.out.print(icon);
            }
            System.out.println("");
        }
    }

    public void otherTriangle() {
        for (int x = 1; x <= counter; x++) {
            for (int y = counter - x + 1; y > 0; y--) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }

    public void fancyTriangle() {
        for (int x = 1; x <= counter; x++) {
            for (int y = 1; y <= x; y++) {
                System.out.print(icon);
            }
            System.out.println("");
        }

        for (int x = 1; x < counter; x++) {
            counter --;
            for (int y = counter - x + 1; y > 0; y--) {
                System.out.print(icon);
            } counter ++;
            System.out.println("");
        }
    }
}
