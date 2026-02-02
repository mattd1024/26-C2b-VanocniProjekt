package worldObjects;

import game.Colors;
import map.MapObject;

public class Resupply extends MapObject {
    private int ammoAmount;
    private int healthAmount;

    public Resupply(int ammoAmount, int healthAmount) {
        description = "Zasobovaci raketa: prikazem collect ji seberes a doplni se ti zivoty a naboje do plna";
        icon = Colors.RED+"R "+Colors.RESET;
        this.ammoAmount = ammoAmount;
        this.healthAmount = healthAmount;
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
