package map;

import java.util.GregorianCalendar;

/**
 * MapHelper je pomocna trida pro kontrolovani udaju o mape a souradnicich, ktere zrovna nemusi souviset s konkretni mapou
 */
public class MapHelper {
    /**
     * Kontroluje jestli koordinaty x a y jsou validni
     * @param x Souradnice x
     * @param y Souradnice y
     * @return Boolean true/false
     */
    public static boolean isValidCoordinate(int x, int y, int width, int height) {
        if (x < 0 || y < 0) {
            return false;
        }

        if (x >= width || y >= height) {
            return false;
        }

        return true;
    }
}
