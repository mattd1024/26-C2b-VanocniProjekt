package worldObjects;

import map.MapObject;

public class Wall extends MapObject {
    public Wall() {
        icon = "# ";
        isWalkable = false;
        isSeeThrough = false;
    }
}
