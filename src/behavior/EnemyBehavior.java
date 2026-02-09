package behavior;

import entities.Enemy;
import entities.Player;
import game.Colors;
import game.Console;
import map.Map;
import map.MapObject;
import worldObjects.Floor;

/**
 * Trida EnemyBehavior urcuje jak se ma nepritel chovat
 * Napriklad pohyb po mape, utok na hrace
 */
public class EnemyBehavior {
    private int damage;

    public EnemyBehavior(int damage) {
        this.damage = damage;
    }

    /**
     * AI logika nepritele
     * @param map Mapa
     * @param player Hrac
     * @param enemy Nepritel
     */
    public void act(Map map, Player player, Enemy enemy) {
        // Souradnice nepritele
        int ex = enemy.getX();
        int ey = enemy.getY();

        // Souradnice hrace
        int px = player.getX();
        int py = player.getY();

        // Pokud nepritel nevidi hrace tak nic nedela
        if (!map.canSee(ex, ey, px, py)) {
            return;
        }

        // Zde provedeme utok, pokud je hrac blizko, pokud neni blizko tak v dalsim kroku udelame pohyb
        if (Math.abs(ex - px) + Math.abs(ey - py) == 1) {
            player.takeDamage(damage);
            Console.printColorMessage("Nepritel te zasahl za: " + damage, Colors.RED);
            Console.printEnter();
            return;
        }

        // Pouzijeme jednodussi bresenhamuv algoritmikus pro pohyb, 1 krok
        // Pocitame rozdil
        int dx = px - ex;
        int dy = py - ey;

        int stepX = 0;
        int stepY = 0;

        if (Math.abs(dx) > Math.abs(dy)) {
            if (dx > 0) {
                stepX = 1;
            } else {
                stepX = -1;
            }
        } else {
            if (Math.abs(dy) > 0) {
                if (dy > 0) {
                    stepY = 1;
                } else {
                    stepY = -1;
                }
            }
        }

        int targetX = ex + stepX;
        int targetY = ey + stepY;

        MapObject targetMapObject = map.getMapObject(targetX, targetY);

        // Pokud se sem nemuzeme pohnout nebo cil je hrac
        if (!(targetMapObject instanceof Floor)) {
            return;
        }

        // Posuneme nepritele
        map.addMapObject(targetX, targetY, enemy);
        map.addMapObject(ex, ey, new Floor());
        enemy.setX(targetX);
        enemy.setY(targetY);
    }
}
