package worldObjects;

import game.Colors;
import map.MapObject;

public class Door extends MapObject {
    private String targetRoomID;
    private int targetX;
    private int targetY;

    public Door() {
        targetRoomID = null;
        description = "Dvere: kdyz do nich vstoupis pohybem tak te presunou do jine mistnosti";
        icon = Colors.GREEN+"D "+ Colors.RESET;
        isWalkable = false;
        isSeeThrough = false;
    }

    public Door(String targetRoomID, int targetX, int targetY) {
        this();
        this.targetRoomID = targetRoomID;
        this.targetX = targetX;
        this.targetY = targetY;
    }

    public String getTargetRoomID() {
        return targetRoomID;
    }

    public void setTargetRoomID(String targetRoomID) {
        this.targetRoomID = targetRoomID;
    }

    public int getTargetX() {
        return targetX;
    }

    public void setTargetX(int targetX) {
        this.targetX = targetX;
    }

    public int getTargetY() {
        return targetY;
    }

    public void setTargetY(int targetY) {
        this.targetY = targetY;
    }
}
