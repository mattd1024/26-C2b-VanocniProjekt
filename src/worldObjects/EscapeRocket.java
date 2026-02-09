package worldObjects;

import game.Colors;
import map.MapObject;

public class EscapeRocket extends MapObject {
    public EscapeRocket() {
        description = "Unikova raketa: muzes uniknout jestli mas dostatek morkitu (200)";
        icon = Colors.BLUE + "X " + Colors.RESET;
        isWalkable = false;
        isSeeThrough = false;
    }
}
