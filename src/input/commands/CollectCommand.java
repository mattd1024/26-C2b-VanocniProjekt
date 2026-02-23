package input.commands;

import entities.Entity;
import entities.Player;
import game.Colors;
import game.Console;
import input.Command;
import inventory.Inventory;
import map.Map;
import map.MapHelper;
import map.MapObject;
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
            Console.printError("Jsi moc daleko");
            return null;
        }

        // Vezmeme entitu a zjistime jestli je resupply
        MapObject mapObject = map.getMapObject(x, y);
        if (!(mapObject instanceof Resupply)) {
            Console.printError("Zde neni zasobovaci raketa");
            return null;
        }
        Resupply resupply = (Resupply) mapObject;

        // Zjistime jestli ma hrac jiz maximalni zdravi a naboje
        if (player.getHealth() >= player.getMAX_HEALTH() && inventory.getAmmo() >= player.getMAX_AMMO()) {
            Console.printError("Jiz mas plne zivoty i naboje.");
            return null;
        }

        // Doplnime hracovy zivoty a naboje
        int newHealth = Math.min(player.getMAX_HEALTH(), player.getHealth() + resupply.getHealthAmount());
        int newAmmo = Math.min(player.getMAX_AMMO(), inventory.getAmmo() + resupply.getAmmoAmount());

        // Nastavime hodnoty
        player.setHealth(newHealth);
        inventory.setAmmo(newAmmo);

        // Odstranime raketu
        map.addMapObject(x, y, new Floor());

        Console.printColorMessage("Uspesne si sebral zasobovaci raketu", Colors.GREEN);

        return Result.END_TURN;
    }
}
