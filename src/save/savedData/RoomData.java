package save.savedData;

import java.util.List;

public class RoomData {
    private String roomID;
    private String name;
    private String description;
    private MapData map;

    public RoomData(String name, String description, MapData map, String roomID) {
        this.roomID = roomID;
        this.name = name;
        this.description = description;
        this.map = map;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MapData getMap() {
        return map;
    }

    public void setMap(MapData map) {
        this.map = map;
    }

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }
}
