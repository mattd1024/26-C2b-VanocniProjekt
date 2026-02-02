package worldObjects;

import map.MapObject;

public class Floor extends MapObject {
    public Floor() {
        description = "Podlaha: mas schopnost po ni chodit :D";
        icon = "· ";
        isWalkable = true;
        isSeeThrough = true;
    }


}
