package input.commands;

import entities.Player;
import game.Colors;
import game.Console;
import input.Command;
import inventory.Inventory;
import map.Map;
import map.MapHelper;
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
    public Result execute() {
        Inventory inventory = player.getInventory();

        // Jsou souradnice validni
        if (!MapHelper.isValidCoordinate(x, y, map.getWidth(), map.getHeight())) {
            Console.printError("Nespravne souradnice");
            return null;
        }

        // Zjistime vzdálenost mezi hracem a resupply
        int dx = Math.abs(player.getX() - x);
        int dy = Math.abs(player.getY() - y);

        // Pokud neni dost blizko
        if (dx > 1 || dy > 1) {
            Console.printError("Jsi moc daleko od zasobovaci rakety");
            return null;
        }

        // ZJistime jestli objekt na x y je resupply
        if (map.getGrid()[y][x] instanceof Resupply) {
            // Zjistime jestli hrac ma maximalni mnozstvi zivotu a naboju a pripadne odmitneme pozadavek
            if (player.getHealth() == 100 && inventory.getAmmo() == 100) {
                Console.printError("Jiz mas plne zivoty a naboje");
            } else {
                player.setHealth(100);
                inventory.setAmmo(100);
                map.addMapObject(x, y, new Floor());
                Console.printColorMessage("Uspesne si sebral zasobovaci raketu", Colors.GREEN);
            }
        } else {
            Console.printError("Na tomto miste neni zasobovaci raketa");
        }

        return Result.CONTINUE;
    }
}
