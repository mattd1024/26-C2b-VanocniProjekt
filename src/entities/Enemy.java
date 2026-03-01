package entities;

import behavior.EnemyBehavior;
import game.Colors;
import map.Map;

/**
 * Trida Enemy je nepritel, dokaze se pohybovat po mape a utocit na hrace
 */
public class Enemy extends Entity{
    private EnemyBehavior enemyBehavior;
    private int damage;

    public Enemy() {
        description = "Nepritel pavouk: zbranema ho musis zneskodnit";
        this.health = MAX_HEALTH;
        icon = Colors.RED+"E "+Colors.RESET;
        isWalkable = false;
        isSeeThrough = false;
        damage = 20;
        enemyBehavior = new EnemyBehavior(damage);
    }

    public Enemy(int health) {
        this();
        this.health = health;
    }

    public void startAI(Map map, Player player) {
        enemyBehavior.act(map, player, this);
    }



}
