package map;

public class MapObject {
    protected int x;
    protected int y;
    protected String icon;
    protected boolean isWalkable;
    protected boolean isSeeThrough;

    public boolean isWalkable() {
        return false;
    }

    public boolean isSeeThrough() {
        return false;
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
}
