package inventory;

import inventory.items.Weapon;
import worldObjects.OreNode;

import java.util.ArrayList;

public class Inventory {
    private int NitraAmount;
    private int GoldAmount;
    private int MorkiteAmount;
    private ArrayList<Weapon> weapons = new ArrayList<>();
    private String activeWeapon;
    private int Ammo;

    public void addMineral(OreNode.MineralType mineralType, int amount) {
        switch (mineralType) {
            case NITRA:
                NitraAmount += amount;
                break;
                case GOLD:
                GoldAmount += amount;
                break;
                case MORKITE:
                MorkiteAmount += amount;
                break;
        }
    }

    public void addWeapon(Weapon weapon) {
        weapons.add(weapon);
    }

    public Weapon getActiveWeapon() {
        for (Weapon weapon : weapons) {
            if (weapon.getName().equals(activeWeapon)) {
                return weapon;
            }
        }
        return null;
    }

    public String getActiveWeaponID() {
        return activeWeapon;
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

    public int getAmmo() {
        return Ammo;
    }

    public void setAmmo(int ammo) {
        Ammo = ammo;
    }

    public void setActiveWeapon(String activeWeapon) {
        this.activeWeapon = activeWeapon;
    }
}
