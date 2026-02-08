package inventory.items;

/**
 * Trida Item reprezentuje predmety
 */
public class Item {
    protected String name;

    public Item(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
