package rooms;

import java.util.ArrayList;

/**
 * Trida RoomManager obsahuje vsechny mistnosti a spravuje je
 */
public class RoomManager {
    private ArrayList<Room> rooms = new ArrayList<>();
    private String currentRoomID;

    public RoomManager() {
        currentRoomID = "room01";
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public Room getRoomByID(String roomID) {
        for (Room room : rooms) {
            if (room.getRoomID().equals(roomID)) {
                return room;
            }
        }
        return null;
    }

    public void printActiveRoom() {
        for (Room room : rooms) {
            if (room.getRoomID().equals(currentRoomID)) {
                room.getMap().printMap();
            }
        }
    }

    public Room getCurrentRoom() {
        return getRoomByID(currentRoomID);
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

    public String getCurrentRoomID() {
        return currentRoomID;
    }

    public void setCurrentRoomID(String currentRoomID) {
        this.currentRoomID = currentRoomID;
    }
}
