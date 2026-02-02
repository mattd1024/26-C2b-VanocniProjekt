package input.commands;

import entities.Entity;
import entities.Player;
import game.Console;
import input.Command;
import inventory.Inventory;
import map.Map;
import map.MapObject;
import worldObjects.Floor;
import worldObjects.OreNode;

public class MineCommand implements Command {
    private final int x;
    private final int y;
    private final Map map;
    private final Player player;

    public MineCommand(int x, int y, Map map, Player player) {
        this.x = x;
        this.y = y;
        this.map = map;
        this.player = player;
    }

    @Override
    public void execute() {
        // Jsou souradnice validni
        if (y < 0 || y >= map.getMap().length || x < 0 || x >= map.getMap()[0].length) {
            System.out.println("Nespravne koordinaty");
            return;
        }

        // Zjistime vzdálenost mezi hracem a rudou
        int dx = Math.abs(player.getX() - x);
        int dy = Math.abs(player.getY() - y);

        // Pokud neni dost blizko
        if (dx > 1 || dy > 1) {
            System.out.println("Jsi moc daleko od rudy");
            Console.printEnter();
            return;
        }

        // Vezmeme mapObject a zjistime jestli existuje
        MapObject mapObject = map.getMapObject(y, x);
        if (!(mapObject instanceof OreNode)) {
            System.out.println("Zde neni ruda");
            Console.printEnter();
            return;
        }

        // Zapocneme tezeni
        OreNode oreNode = (OreNode) mapObject;
        OreNode.MineralType typeOfOre = oreNode.getMineralType();
        int mined = oreNode.mineOre(80);

        player.getInventory().addMineral(typeOfOre, mined);

        map.addMapObject(y, x, new Floor());

        System.out.println("Vytezil si " + mined + " rudy " + typeOfOre.toString());
        Console.printEnter();
    }
}
