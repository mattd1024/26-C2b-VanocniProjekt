package entities;

import map.MapObject;

/**
 * Trida Entity je rodicovska vzorova trida pro jakykoliv charakter ve hre
 */
public class Entity extends MapObject {
    protected String name;
    protected int health;
    protected final int MAX_HEALTH = 100;

    public void takeDamage(int dmgAmount) {
        health -= dmgAmount;
    }

    public boolean isAlive() {
        if (health <= 0) {
            return false;
        }
        return true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMAX_HEALTH() {
        return MAX_HEALTH;
    }
}
