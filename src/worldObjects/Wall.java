package worldObjects;

import map.MapObject;

public class Wall extends MapObject {
    public Wall() {
        description = "Stena: bohuzel do ni chodit nemuzes";
        icon = "# ";
        isWalkable = false;
        isSeeThrough = false;
    }
}
