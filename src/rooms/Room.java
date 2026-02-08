package rooms;

import map.Map;

/**
 * Trida Room reprezentuje mistnost
 * Obsahuje mapu, ID, jmeno, deskripci
 */
public class Room {
    private Map map;
    private String roomID;
    private String name;
    private String description;

    public Room(Map map, String roomID, String name, String description) {
        this.map = map;
        this.roomID = roomID;
        this.name = name;
        this.description = description;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
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

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }
}
