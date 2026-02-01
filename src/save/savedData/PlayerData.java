package save.savedData;

public class PlayerData {
    private int health;
    private PositionData position;
    private InventoryData inventory;

    public PlayerData(int health, PositionData position, InventoryData inventory) {
        this.health = health;
        this.position = position;
        this.inventory = inventory;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public PositionData getPosition() {
        return position;
    }

    public void setPosition(PositionData position) {
        this.position = position;
    }

    public InventoryData getInventory() {
        return inventory;
    }

    public void setInventory(InventoryData inventory) {
        this.inventory = inventory;
    }
}
