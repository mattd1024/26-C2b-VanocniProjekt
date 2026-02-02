package save.savedData;

public class WeaponData {
    private String name;
    private int range;
    private int damage;
    private int ammoConsumption;

    public WeaponData(String name, int range, int damage,  int ammoConsumption) {
        this.name = name;
        this.range = range;
        this.damage = damage;
        this.ammoConsumption = ammoConsumption;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmmoConsumption() {
        return ammoConsumption;
    }

    public void setAmmoConsumption(int ammoConsumption) {
        this.ammoConsumption = ammoConsumption;
    }
}
