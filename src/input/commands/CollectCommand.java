package input.commands;

import entities.Player;
import game.Colors;
import game.Console;
import input.Command;
import map.Map;
import worldObjects.Floor;
import worldObjects.Resupply;

/**
 * CollectCommand zpracuje sbirani objektu Resupply
 */
public class CollectCommand implements Command {
    private final int x;
    private final int y;
    private final Player player;
    private final Map map;

    public CollectCommand(String[] args, Player player, Map map) {
        this.x = Integer.parseInt(args[0]);
        this.y = Integer.parseInt(args[1]);
        this.player = player;
        this.map = map;
    }

    @Override
    public void execute() {
        // Jsou souradnice validni
        if (!map.isValidCoordinate(x, y)) {
            Console.printError("Nespravne souradnice");
            return;
        }

        // Zjistime vzdálenost mezi hracem a resupply
        int dx = Math.abs(player.getX() - x);
        int dy = Math.abs(player.getY() - y);

        // Pokud neni dost blizko
        if (dx > 1 || dy > 1) {
            Console.printError("Jsi moc daleko od zasobovaci rakety");
            return;
        }

        // ZJistime jestli objekt na x y je resupply a pouzijeme ho
        if (map.getGrid()[y][x] instanceof Resupply) {
            player.setHealth(100);
            player.getInventory().setAmmo(100);
            map.addMapObject(y, x, new Floor());
            Console.printColorMessage("Uspesne si sebral zasobovaci raketu", Colors.GREEN);
        } else {
            Console.printError("Na tomto miste neni zasobovaci raketa");
        }
    }
}
