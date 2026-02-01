package rooms;

import java.util.ArrayList;

public class RoomManager {
    private ArrayList<Room> rooms = new ArrayList<>();
    private String currentRoomID;

    public RoomManager() {
        currentRoomID = "room01";
    }

    public void changeRoom() {

    }

    public void addRoom(Room room) {
        rooms.add(room);
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
