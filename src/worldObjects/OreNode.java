package worldObjects;

import inventory.MineralType;
import map.MapObject;

public class OreNode extends MapObject {
    private int amount;
    private MineralType mineralType;

    public int decreaseOre() {
        return 0;
    }
}
