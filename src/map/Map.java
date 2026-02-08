package map;

/**
 * Trida map se stara o mapu
 * Obsahuje 2d array MapObject[][] grid
 * Poskytuje ruzne metody k praci s mapou a ziskanim informaci od ni
 */
public class Map {
    MapObject[][] grid;

    public Map(int numRows, int numCols) {
        grid = new MapObject[numRows][numCols];
    }

    /**
     * Do konzole vyprinti mapu
     */
    public void printMap() {
        // Vyprintime horizontalni navadeci listu
        System.out.print("  ");
        for (int i = 0; i < grid[0].length; i++) {
            System.out.print(formatGuideNum(i));
        }
        System.out.println();

        // Vyprintime mapu s listou
        for (int row = 0; row < grid.length; row++) {
            // Vyprintime vertikalni navadeci listu
            System.out.print((row) + " ");
            // Vyprintime mapu
            for (int col = 0; col < grid[0].length; col++) {
                MapObject mapObject = grid[row][col];
                System.out.print(mapObject.getIcon());
            }
            System.out.println();
        }
    }

    /**
     * Vezme int a vraci formatovany string se stejnou hodnotou a vzdy aby zabiral dve mista
     * Pouze pro [0-9]
     * @return
     */
    public String formatGuideNum(int num) {
        if (num < 0 || num > 9) {
            throw new IllegalArgumentException("Navadeci cislo moc velke, musi byt [0-9]");
        } else {
            return num + " ";
        }
    }

    /**
     * Kontroluje jestli objekt na x a y je choditelny
     * @param x Souradnice x
     * @param y Souradnice y
     * @return Boolean true/false
     */
    public boolean isWalkableAt(int x, int y) {
        if (grid[y][x].isWalkable()) {
            return true;
        }
        return false;
    }

//    public ArrayList<MapObject> getMapObjectsInBetween(int x1, int y1, int x2, int y2) {
//        ArrayList<MapObject> mapObjects = new ArrayList<>();
//
//
//        return objectsBetween;
//    }

    /**
     * Kontroluje jestli koordinaty x a y jsou validni
     * @param x Souradnice x
     * @param y Souradnice y
     * @return Boolean true/false
     */
    public boolean isValidCoordinate(int x, int y) {
        int width = grid[0].length;
        int height = grid.length;

        if (x < 0 || y < 0) {
            return false;
        }

        if (x > width || y > height) {
            return false;
        }

        return true;
    }

    /**
     * Prida MapObject na koordinaty x a y
     * @param x Souradnice x
     * @param y Souradnice y
     * @param mo MapObject mapObject
     */
    public void addMapObject(int x, int y, MapObject mo) {
        grid[x][y] = mo;
    }

    public MapObject getMapObject(int row, int col) {
        return grid[row][col];
    }

    public MapObject[][] getGrid() {
        return grid;
    }

    public void setGrid(MapObject[][] grid) {
        this.grid = grid;
    }

}
