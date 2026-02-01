package worldObjects;

import game.Colors;
import map.MapObject;

public class OreNode extends MapObject {
    private int amount;
    private MineralType mineralType;

    public enum MineralType {
        NITRA,
        GOLD,
        MORKITE
    }

    public OreNode() {
        isWalkable = true;
        isSeeThrough = true;
        amount = 40;
    }

    public OreNode(MineralType mineralType) {
        this();
        this.mineralType = mineralType;
        switch (mineralType) {
            case NITRA:
                icon = Colors.RED+"O "+Colors.RESET;
                break;
            case GOLD:
                icon = Colors.YELLOW+"O "+Colors.RESET;
                break;
            case MORKITE:
                icon = Colors.BLUE+"O "+Colors.RESET;
                break;
        }
    }

    public OreNode(int amount, MineralType mineralType) {
        this(mineralType);
        this.amount = amount;
        this.mineralType = mineralType;
    }

    public int mineOre(int amount) {
        int mined = Math.min(amount, this.amount);
        this.amount -= mined;
        return mined;
    }
}
