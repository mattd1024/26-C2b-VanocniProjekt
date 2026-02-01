package inventory.items;

public class Weapon extends Item{
    private int range;
    private int damage;

    public Weapon(String name, int range, int damage) {
        super(name);
        this.range = range;
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    @Override
    public String toString() {
        return "Weapon{" +
                "range=" + range +
                ", damage=" + damage +
                '}';
    }
}
