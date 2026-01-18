package behavior;

import entities.Enemy;
import entities.Player;
import map.Map;

public interface Behavior {
    void act(Map map, Player player, Enemy enemy);
}
