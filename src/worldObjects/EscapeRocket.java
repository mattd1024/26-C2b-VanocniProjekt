package worldObjects;

import game.Colors;
import map.MapObject;

/**
 * Reprezentuje unikovou raketu
 * Kdyz hrac ma dostatek morkitu tak ji muze pouzit komandem escape a vyhrat hru
 */
public class EscapeRocket extends MapObject {
    public EscapeRocket() {
        description = "Unikova raketa: muzes uniknout jestli mas dostatek morkitu (200)";
        icon = Colors.BLUE + "X " + Colors.RESET;
        isWalkable = false;
        isSeeThrough = false;
    }
}
