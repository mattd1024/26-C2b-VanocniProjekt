package input.commands;

import entities.Player;
import game.Colors;
import game.Console;
import input.Command;
import inventory.Inventory;
import map.Map;
import map.MapHelper;
import map.MapObject;
import worldObjects.Floor;
import worldObjects.OreNode;

/**
 * MineCommand zpracuje tezeni rudy OreNode v mape
 */
public class MineCommand implements Command {
    private final int x;
    private final int y;
    private final Map map;
    private final Player player;

    public MineCommand(String[] args, Map map, Player player) {
        this.x = Integer.parseInt(args[0]);
        this.y = Integer.parseInt(args[1]);
        this.map = map;
        this.player = player;
    }

    @Override
    public Result execute() {
        Inventory inventory = player.getInventory();

        // Jsou souradnice validni
        if (!MapHelper.isValidCoordinate(x, y, map.getWidth(), map.getHeight())) {
            Console.printError("Nespravne souradnice");
            return null;
        }

        // Zjistime vzdálenost mezi hracem a rudou
        int dx = Math.abs(player.getX() - x);
        int dy = Math.abs(player.getY() - y);

        // Pokud neni dost blizko
        if (dx > 1 || dy > 1) {
            System.out.println("Jsi moc daleko od rudy");
            Console.printEnter();
            return null;
        }

        // Vezmeme mapObject a zjistime jestli existuje
        MapObject mapObject = map.getMapObject(x, y);
        if (!(mapObject instanceof OreNode)) {
            System.out.println("Zde neni ruda");
            Console.printEnter();
            return null;
        }

        // Vytvorime objekty
        OreNode oreNode = (OreNode) mapObject;
        OreNode.MineralType typeOfOre = oreNode.getMineralType();

        // Muze hrac tezit? (ma plny inventar urciteho typu rudy?)
        if (inventory.canMine(40, typeOfOre)) {
            int mined = oreNode.mineOre(80);
            inventory.addMineral(typeOfOre, mined);
            map.addMapObject(x, y, new Floor());

            Console.printColorMessage("Vytezil si " + mined + " rudy " + typeOfOre.toString(), Colors.GREEN);
            Console.printEnter();
            Console.printSpace();
        } else {
            Console.printColorMessage("Tuhle rudu uz nemuzes tezit!", Colors.RED);
            Console.printEnter();
            Console.printSpace();
        }

        return Result.CONTINUE;
    }
}
