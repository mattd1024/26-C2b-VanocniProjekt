package worldObjects;

import game.Colors;
import map.MapObject;

/**
 * Trida OreNode reprezentuje rudu
 * Obsahuje mnozstvi ktere lze snizit
 * Muze byt typu nitra, gold a morkite
 */
public class OreNode extends MapObject {
    private int amount;
    private MineralType mineralType;

    public enum MineralType {
        NITRA,
        GOLD,
        MORKITE
    }

    public OreNode() {
        isWalkable = false;
        isSeeThrough = false;
        amount = 40;
    }

    public OreNode(MineralType mineralType) {
        this();
        this.mineralType = mineralType;
        switch (mineralType) {
            case NITRA:
                icon = Colors.RED+"O "+Colors.RESET;
                description = "Nitra: muzes vytezit pro privolani zasobovaci rakety";
                break;
            case GOLD:
                icon = Colors.YELLOW+"O "+Colors.RESET;
                description = "Zlato: muzes vytezit pro moznost koupit si zbrane u obchodobota";
                break;
            case MORKITE:
                icon = Colors.BLUE+"O "+Colors.RESET;
                description = "Morkite: muzes vytezit pro splneni mise";
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public MineralType getMineralType() {
        return mineralType;
    }

    public void setMineralType(MineralType mineralType) {
        this.mineralType = mineralType;
    }
}
