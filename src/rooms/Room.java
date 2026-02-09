package rooms;

import entities.Enemy;
import entities.Player;
import map.Map;
import map.MapObject;
import worldObjects.Floor;

import java.util.ArrayList;
import java.util.List;

/**
 * Trida Room reprezentuje mistnost
 * Obsahuje mapu, ID, jmeno, deskripci
 */
public class Room {
    private Map map;
    private String roomID;
    private String name;
    private String description;
    private List<Enemy> enemies;

    public Room(Map map, String roomID, String name, String description) {
        this.map = map;
        this.roomID = roomID;
        this.name = name;
        this.description = description;

        this.enemies = new ArrayList<>();
        for (int y = 0 ; y < map.getHeight() ; y++) {
            for (int x = 0 ; x < map.getWidth() ; x++) {
                MapObject mapObject = map.getMapObject(x, y);

                if (mapObject instanceof Enemy) {
                    Enemy enemy = (Enemy) mapObject;
                    if (!enemies.contains(enemy)) {
                        enemies.add(enemy);
                        enemy.setX(x);
                        enemy.setY(y);
                    } else {
                        map.addMapObject(x, y, new Floor());
                    }
                }
            }
        }
    }

    public void removeEnemy(Enemy requestedEnemy) {
        enemies.remove(requestedEnemy);
    }

    public void startEnemies(Player player) {
        for (Enemy enemy : enemies) {
            if (enemy.isAlive()) {
                enemy.startAI(map, player);
            }
        }
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }
}
