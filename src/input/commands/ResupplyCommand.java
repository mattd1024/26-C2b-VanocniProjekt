package input.commands;

import game.Console;
import input.Command;
import inventory.Inventory;
import map.Map;
import worldObjects.Resupply;

public class ResupplyCommand implements Command {
    private final int x;
    private final int y;
    private final Inventory inventory;
    private final Map map;

    public ResupplyCommand(int x, int y, Inventory inventory, Map map) {
        this.x = x;
        this.y = y;
        this.inventory = inventory;
        this.map = map;
    }

    @Override
    public void execute() {
        // Jsou sourdanice validni
        if (y < 0 || y >= map.getMap().length || x < 0 || x >= map.getMap()[0].length) {
            System.out.println("Nespravne souradnice");
            Console.printEnter();
            return;
        }

        // Zjistime jestli ma dostatek nitry a pripadne vlozime resupply do mapy
        if (inventory.getNitraAmount() >= 80) {
            inventory.setNitraAmount(inventory.getNitraAmount() - 80);
            map.addMapObject(y, x, new Resupply(100, 100));
        } else {
            System.out.println("Nemas dostatek nitry, potrebujes minimalne 80");
            Console.printEnter();
        }
    }
}
