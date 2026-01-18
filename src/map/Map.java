package map;

public class Map {
    MapObject[][] map;
    private int roomID;

    public Map(int xSize, int ySize) {
        map = new MapObject[xSize][ySize];
    }

    public void printMap() {

    }

    public boolean canSee(MapObject mo1, MapObject mo2) {
        return false;
    }

    public boolean isInRange(MapObject mo1, MapObject mo2, int range) {
        return false;
    }
}
