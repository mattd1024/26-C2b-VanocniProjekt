package worldObjects;

import map.MapObject;

/**
 * Floor reprezentuje objekt podlahy
 */
public class Floor extends MapObject {
    public Floor() {
        description = "Podlaha: mas schopnost po ni chodit :D";
        icon = "· ";
        isWalkable = true;
        isSeeThrough = true;
    }


}
