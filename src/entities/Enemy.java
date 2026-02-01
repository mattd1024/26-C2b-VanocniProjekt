package entities;

import behavior.Behavior;
import game.Colors;

public class Enemy extends Entity{
    private Behavior behavior; //TODO add AI enemy behavior

    public Enemy() {
        this.health = 100;
        icon = Colors.RED+"E "+Colors.RESET;
    }

    public Enemy(int health) {
        this();
        this.health = health;
    }



}
