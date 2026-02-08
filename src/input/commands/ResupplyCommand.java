package input.commands;

import game.Console;
import input.Command;
import inventory.Inventory;
import map.Map;
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
    public void execute() {
        // Jsou souradnice validni
        if (!map.isValidCoordinate(x, y)) {
            Console.printError("Nespravne souradnice");
            return;
        }

        // Zjistime jestli ma dostatek nitry a pripadne vlozime resupply do mapy
        if (inventory.getNitraAmount() >= 80) {
            inventory.setNitraAmount(inventory.getNitraAmount() - 80);
            map.addMapObject(y, x, new Resupply(100, 100));
        } else {
            Console.printError("Nemas dostatek nitry, potrebujes minimalne 80");
        }
    }
}
