package entities;

import game.Colors;
import inventory.Inventory;
import inventory.items.Weapon;
import worldObjects.OreNode;

/**
 * Trida Player je hlavni postava hrace
 * Uzivatel za nej hraje
 */
public class Player extends Entity{
    private final int MAX_AMMO = 100;
    private final int MINE_FORCE = 80;

    private Inventory inventory;
    private String actualRoomID;

    public Player() {
        description = "Hrac: tohle jses ty :D";
        icon = Colors.CYAN+"P "+ Colors.RESET;
        inventory = new Inventory();
        health = MAX_HEALTH;
    }

    public Player(int health, Inventory inventory) {
        this();
        this.health = health;
    }

    public String getActualRoomID() {
        return actualRoomID;
    }

    public void setActualRoomID(String actualRoomID) {
        this.actualRoomID = actualRoomID;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getMAX_AMMO() {
        return MAX_AMMO;
    }

    public int getMINE_FORCE() {
        return MINE_FORCE;
    }
}
