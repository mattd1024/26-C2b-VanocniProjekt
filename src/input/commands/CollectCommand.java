package input.commands;

import entities.Player;
import game.Console;
import input.Command;
import map.Map;
import worldObjects.Floor;
import worldObjects.Resupply;

public class CollectCommand implements Command {
    private final int x;
    private final int y;
    private final Player player;
    private final Map map;

    public CollectCommand(int x, int y, Player player, Map map) {
        this.x = x;
        this.y = y;
        this.player = player;
        this.map = map;
    }

    @Override
    public void execute() {
        // Kontrolace, zda-li jsou souradnice mimo mapu
        if (y < 0 || y >= map.getMap().length || x < 0 || x >= map.getMap()[0].length) {
            System.out.println("Nespravne koordinaty");
            Console.printEnter();
            return;
        }

        // Zjistime vzdálenost mezi hracem a resupply
        int dx = Math.abs(player.getX() - x);
        int dy = Math.abs(player.getY() - y);

        // Pokud neni dost blizko
        if (dx > 1 || dy > 1) {
            System.out.println("Jsi moc daleko od resupply");
            Console.printEnter();
            return;
        }

        // ZJistime jestli objekt na x y je resupply a pouzijeme ho
        if (map.getMap()[y][x] instanceof Resupply) {
            player.setHealth(100);
            player.getInventory().setAmmo(100);
            map.addMapObject(y, x, new Floor());
        } else {
            System.out.println("Na tomto miste neni Resupply");
        }
    }
}
