package entities;

import behavior.Behavior;
import game.Colors;

public class Enemy extends Entity{
    private Behavior behavior;

    public Enemy() {
        description = "Nepritel pavouk: zbranema ho musis zneskodnit";
        this.health = 100;
        icon = Colors.RED+"E "+Colors.RESET;
        isWalkable = false;
        isSeeThrough = false;
    }

    public Enemy(int health) {
        this();
        this.health = health;
    }

    public boolean isAlive() {
        if (health <= 0) {
            return false;
        }
        return true;
    }



}
