package map;

public class MapObject {
    protected int x;
    protected int y;
    protected String icon;
    protected boolean isWalkable;
    protected boolean isSeeThrough;
    protected String description;

    public boolean isWalkable() {
        return isWalkable;
    }

    public boolean isSeeThrough() {
        return isSeeThrough;
    }

    public String getIcon() {
        return icon;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
