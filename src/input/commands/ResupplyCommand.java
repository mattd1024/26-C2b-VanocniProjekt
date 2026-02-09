package input.commands;

import game.Console;
import input.Command;
import inventory.Inventory;
import map.Map;
import map.MapHelper;
import map.MapObject;
import worldObjects.Floor;
import worldObjects.Resupply;

/**
 * ResupplyCommand zpracuje spawnovani zasobovaci rakety v mape
 */
public class ResupplyCommand implements Command {
    private final int x;
    private final int y;
    private final Inventory inventory;
    private final Map map;

    public ResupplyCommand(String[] args, Inventory inventory, Map map) {
        this.x = Integer.parseInt(args[0]);
        this.y = Integer.parseInt(args[1]);
        this.inventory = inventory;
        this.map = map;
    }

    @Override
    public Result execute() {
        // Jsou souradnice validni
        if (!MapHelper.isValidCoordinate(x, y, map.getWidth(), map.getHeight())) {
            Console.printError("Nespravne souradnice");
            return null;
        }

        // Muze hrac zavolat zasobovaci raketu na misto x y? (musi byt pouze Floor)
        MapObject mapObject = map.getMapObject(x, y);
        if (!(mapObject instanceof Floor)) {
            Console.printError("Sem nemuzes zavolat zasobovaci raketu (pouze na podlahu)");
            return Result.CONTINUE;
        }

        // Zjistime jestli ma dostatek nitry a pripadne vlozime resupply do mapy
        if (inventory.getNitraAmount() >= 80) {
            inventory.setNitraAmount(inventory.getNitraAmount() - 80);
            map.addMapObject(x, y, new Resupply(100, 100));
        } else {
            Console.printError("Nemas dostatek nitry, potrebujes minimalne 80");
        }
        return Result.CONTINUE;
    }
}
