package game;

import java.util.Random;

public class Character {
    private String name;
    private int hp;
    private int ap;

    public Character(String name, int hp, int ap) {
        this.name = name;
        this.hp = hp;
        this.ap = ap;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAp() {
        return ap;
    }

    public void setAp(int ap) {
        this.ap = ap;
    }

    public int attack() {
        Random random = new Random();
        int attack = random.nextInt(ap + 1);
        return attack;
    }
}
