package worldObjects;

import map.MapObject;

public class Floor extends MapObject {
    public Floor() {
        icon = "· ";
        isWalkable = true;
        isSeeThrough = true;
    }


}
