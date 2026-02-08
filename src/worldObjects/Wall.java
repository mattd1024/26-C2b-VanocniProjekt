package worldObjects;

import map.MapObject;

/**
 * Trida Wall reprezentuje stenu pres kterou nelze videt a nelze chodit
 */
public class Wall extends MapObject {
    public Wall() {
        description = "Stena: bohuzel do ni chodit nemuzes";
        icon = "# ";
        isWalkable = false;
        isSeeThrough = false;
    }
}
