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
        if (getMapObject(x, y).isWalkable()) {
            return true;
        }
        return false;
    }

    /**
     * Prida MapObject na koordinaty x a y
     * @param x Souradnice x
     * @param y Souradnice y
     * @param mo MapObject
     */
    public void addMapObject(int x, int y, MapObject mo) {
        grid[y][x] = mo;
    }

    /**
     * Vrati MapObject na souradnicich x a y
     * @param x Souradnice x
     * @param y Souradnice y
     * @return MapObject
     */
    public MapObject getMapObject(int x, int y) {
        return grid[y][x];
    }

    /**
     * Zjisti jestli dve pozice se muzou v mape videt, bere v potaz objekty mezi pozicemi
     * @param x1 Prvni x souradnice
     * @param y1 Prvni y souradnice
     * @param x2 Druhe x souradnice
     * @param y2 Druhe y souradnice
     * @return True/false
     */
    public boolean canSee(int x1, int y1, int x2, int y2) {
        // Bresenhamuv carovny carovy algoritmus
        // Vypocitame rozdil
        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);

        // Urcuje ktery smer zvolit
        int sx = 1;
        int sy = 1;
        if (x1 > x2) {
            sx = -1;
        }
        if (y1 > y2) {
            sy = -1;
        }

        // Err nam urcuje jak daleko se vzdalujeme od idealni cary mezi pozicemi
        int err = dx - dy;

        while (true) {
            // Zkontrolujeme jestli jsme v cili
            if (x1 == x2 && y1 == y2) {
                break;
            }

            // e2 se bere jako err ale vynasobeny cislem 2, abychom nemuseli resit decimalni cislice
            int e2 = 2 * err;

            // Pohyb
            if (e2 > -dy) {
                err -= dy;
                x1 += sx;
            }
            if (e2 < dx) {
                err += dx;
                y1 += sy;
            }

            if (x1 == x2 && y1 == y2) {
                break;
            }

            MapObject mapObject = getMapObject(x1, y1);
            if (!mapObject.isWalkable() || !mapObject.isSeeThrough()) {
                return false;
            }
        }
        return true;
    }

    public MapObject[][] getGrid() {
        return grid;
    }

    public void setGrid(MapObject[][] grid) {
        this.grid = grid;
    }

    public int getWidth() {
        return grid[0].length;
    }

    public int getHeight() {
        return grid.length;
    }

}
