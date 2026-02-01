package inventory;

import inventory.items.Weapon;
import worldObjects.OreNode;

import java.util.ArrayList;

public class Inventory {
    private int NitraAmount;
    private int GoldAmount;
    private int MorkiteAmount;
    private ArrayList<Weapon> weapons = new ArrayList<>();

    public void addMineral(OreNode.MineralType mineralType, int amount) {
        switch (mineralType) {
            case NITRA:
                NitraAmount = amount;
                break;
                case GOLD:
                GoldAmount = amount;
                break;
                case MORKITE:
                MorkiteAmount = amount;
                break;
        }
    }

    public void addWeapon(Weapon weapon) {
        weapons.add(weapon);
    }

    public int getNitraAmount() {
        return NitraAmount;
    }

    public void setNitraAmount(int nitraAmount) {
        NitraAmount = nitraAmount;
    }

    public int getGoldAmount() {
        return GoldAmount;
    }

    public void setGoldAmount(int goldAmount) {
        GoldAmount = goldAmount;
    }

    public int getMorkiteAmount() {
        return MorkiteAmount;
    }

    public void setMorkiteAmount(int morkiteAmount) {
        MorkiteAmount = morkiteAmount;
    }

    public ArrayList<Weapon> getWeapons() {
        return weapons;
    }

    public void setWeapons(ArrayList<Weapon> weapons) {
        this.weapons = weapons;
    }
}
