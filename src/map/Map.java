package map;

public class Map {
    MapObject[][] map;
    private int roomID;

    public Map(int numRows, int numCols) {
        map = new MapObject[numRows][numCols];
    }

    public void printMap() {
        // Print horizontal guide bar
        System.out.print("  ");
        for (int i = 0; i < map[0].length; i++) {
            System.out.print(formatGuideNum(i));
        }
        System.out.println();

        // Print map
        for (int row = 0; row < map.length; row++) {
            System.out.print((row) + " "); // Print vertical guide bar
            for (int col = 0; col < map[0].length; col++) {
                MapObject mapObject = map[row][col];
                System.out.print(mapObject.getIcon());
            }
            System.out.println();
        }
    }

    /**
     * Takes an int and returns a formatted String with the same value and double digits.
     * Only for [0-9]
     * @return
     */
    public String formatGuideNum(int num) {
        if (!(num < 0 || num > 9)) {
            return num + " ";
        } else {
            throw new IllegalArgumentException("Guide num is too high/low");
        }
    }

    public boolean canSee(MapObject mo1, MapObject mo2) {
        return false;
    }

    public boolean isInRange(MapObject mo1, MapObject mo2, int range) {
        return false;
    }

    public void addMapObject(int row, int col, MapObject mo) {
        map[row][col] = mo;
    }

    public MapObject[][] getMap() {
        return map;
    }

    public void setMap(MapObject[][] map) {
        this.map = map;
    }

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }
}
