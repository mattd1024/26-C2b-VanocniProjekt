package save.savedData;

public class WeaponData {
    private String name;
    private int range;
    private int damage;

    public WeaponData(String name, int range, int damage) {
        this.name = name;
        this.range = range;
        this.damage = damage;
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
}
