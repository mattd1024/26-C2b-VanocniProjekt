package map;

import java.util.ArrayList;
import java.util.List;

public class Map {
    MapObject[][] map;
    private int roomID;

    public Map(int numRows, int numCols) {
        map = new MapObject[numRows][numCols];
    }

    public void printMap() {
        // Vyprintime horizontalni navadeci listu
        System.out.print("  ");
        for (int i = 0; i < map[0].length; i++) {
            System.out.print(formatGuideNum(i));
        }
        System.out.println();

        // Vyprintime mapu
        for (int row = 0; row < map.length; row++) {
            System.out.print((row) + " "); // Vyprintime vertikalni navadeci listu
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

    public boolean isWalkableAt(int x, int y) {
        if (map[y][x].isWalkable()) {
            return true;
        }
        return false;
    }

    public ArrayList<MapObject> getMapObjectsInBetween(int x1, int y1, int x2, int y2) {
        ArrayList<MapObject> objectsBetween = new ArrayList<>();

        int dx = x2 - x1;
        int dy = y2 - y1;

        int steps = Math.max(Math.abs(dx), Math.abs(dy));
        if (steps == 0) return objectsBetween;

        float stepX = dx / (float) steps;
        float stepY = dy / (float) steps;

        float currentX = x1;
        float currentY = y1;

        for (int i = 1; i < steps; i++) {
            currentX += stepX;
            currentY += stepY;
            int cx = Math.round(currentX);
            int cy = Math.round(currentY);
            if (cy >= 0 && cy < map.length &&
                    cx >= 0 && cx < map[0].length) {
                objectsBetween.add(map[cy][cx]);
            }
        }

        return objectsBetween;
    }


    public void addMapObject(int row, int col, MapObject mo) {
        map[row][col] = mo;
    }

    public MapObject getMapObject(int row, int col) {
        return map[row][col];
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
