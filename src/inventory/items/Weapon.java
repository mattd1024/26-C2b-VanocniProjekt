package inventory.items;

/**
 * Trida Weapon reprezentuje zbrane ktere muze hrac pouzivat
 */
public class Weapon extends Item{
    private int range;
    private int damage;
    private int ammoConsumption;
    private int cost;

    public Weapon(String name, int range, int damage, int ammoConsumption) {
        super(name);
        this.range = range;
        this.damage = damage;
        this.ammoConsumption = ammoConsumption;
    }

    public Weapon(String name, int range, int damage, int ammoConsumption, int cost) {
        super(name);
        this.range = range;
        this.damage = damage;
        this.ammoConsumption = ammoConsumption;
        this.cost = cost;
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

    public int getAmmoConsumption() {
        return ammoConsumption;
    }

    public void setAmmoConsumption(int ammoConsumption) {
        this.ammoConsumption = ammoConsumption;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return name + " | " + "vzdalenost hitnuti: " + range + ", " + "poskozeni: " + damage +  ", " + "konzumace naboju: " + ammoConsumption + ", " + "cena: " + cost;
    }
}
