package worldObjects;

import game.Colors;
import map.MapObject;

public class Door extends MapObject {
    private String targetRoomID;

    public Door() {
        this.targetRoomID = null;
        icon = Colors.GREEN+"D "+ Colors.RESET;
    }

    public Door(String targetRoomID) {
        this();
        this.targetRoomID = targetRoomID;
    }

    public void enter() {

    }

    public String getTargetRoomID() {
        return targetRoomID;
    }

    public void setTargetRoomID(String targetRoomID) {
        this.targetRoomID = targetRoomID;
    }
}
