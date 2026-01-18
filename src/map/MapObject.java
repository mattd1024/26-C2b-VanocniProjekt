package map;

public class MapObject {
    protected int xCoords;
    protected int yCoords;
    protected String icon;
    protected boolean isWalkable;
    protected boolean isSeeThrough;

    public boolean isWalkable() {
        return false;
    }

    public boolean isSeeThrough() {
        return false;
    }
}
