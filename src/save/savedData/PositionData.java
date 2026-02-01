package save.savedData;

public class PositionData {
    private String actualRoomID;
    private int x;
    private int y;

    public PositionData(String actualRoomID, int x, int y) {
        this.actualRoomID = actualRoomID;
        this.x = x;
        this.y = y;
    }

    public String getActualRoomID() {
        return actualRoomID;
    }

    public void setActualRoomID(String actualRoomID) {
        this.actualRoomID = actualRoomID;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
