package entities;

import game.Colors;
import inventory.Inventory;
import inventory.items.Weapon;
import worldObjects.OreNode;

public class Player extends Entity{
    private Inventory inventory;
    private String actualRoomID;

    public Player() {
        icon = Colors.CYAN+"P "+ Colors.RESET;
        inventory = new Inventory();
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

    public void mine(OreNode oreNode) {

    }

    public void attack(Enemy enemy, Weapon weapon) {

    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
