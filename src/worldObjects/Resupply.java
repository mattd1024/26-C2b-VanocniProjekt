package worldObjects;

import game.Colors;
import map.MapObject;

/**
 * Trida Resupply reprezentuje zasobovaci raketu
 * Obsahuje mnozsti naboju a zdravi
 */
public class Resupply extends MapObject {
    private int ammoAmount;
    private int healthAmount;

    public Resupply() {
        isWalkable = false;
        isSeeThrough = false;
        description = "Zasobovaci raketa: prikazem collect ji seberes a doplni se ti zivoty a naboje do plna";
        icon = Colors.RED+"R "+Colors.RESET;
        this.ammoAmount = 100;
        this.healthAmount = 100;
    }

    public int getAmmoAmount() {
        return ammoAmount;
    }

    public void setAmmoAmount(int ammoAmount) {
        this.ammoAmount = ammoAmount;
    }

    public int getHealthAmount() {
        return healthAmount;
    }

    public void setHealthAmount(int healthAmount) {
        this.healthAmount = healthAmount;
    }
}
