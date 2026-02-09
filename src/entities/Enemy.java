package entities;

import behavior.EnemyBehavior;
import game.Colors;
import map.Map;

/**
 * Trida Enemy je nepritel
 */
public class Enemy extends Entity{
    private EnemyBehavior enemyBehavior;

    public Enemy() {
        description = "Nepritel pavouk: zbranema ho musis zneskodnit";
        this.health = 100;
        icon = Colors.RED+"E "+Colors.RESET;
        isWalkable = false;
        isSeeThrough = false;
        enemyBehavior = new EnemyBehavior(20);
    }

    public Enemy(int health) {
        this();
        this.health = health;
    }

    public void startAI(Map map, Player player) {
        enemyBehavior.act(map, player, this);
    }



}
