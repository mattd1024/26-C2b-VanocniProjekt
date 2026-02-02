package save.savedData;

import inventory.items.Weapon;

public class InventoryData {
    private WeaponData[] weapons;
//    private MineralData minerals;
    private int nitra;
    private int gold;
    private int morkite;
    private String activeWeapon;


    public InventoryData(WeaponData[] weapons, int nitra, int gold, int morkite) {
        this.weapons = weapons;
        this.nitra = nitra;
        this.gold = gold;
        this.morkite = morkite;
    }

    public WeaponData[] getWeapons() {
        return weapons;
    }

    public void setWeapons(WeaponData[] weapons) {
        this.weapons = weapons;
    }

    public int getNitra() {
        return nitra;
    }

    public void setNitra(int nitra) {
        this.nitra = nitra;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getMorkite() {
        return morkite;
    }

    public void setMorkite(int morkite) {
        this.morkite = morkite;
    }
}
