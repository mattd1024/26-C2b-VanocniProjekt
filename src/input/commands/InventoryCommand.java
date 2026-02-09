package input.commands;

import game.Colors;
import game.Console;
import input.Command;
import inventory.Inventory;
import inventory.items.Weapon;

/**
 * InventoryCommand vypise inventar hrace
 */
public class InventoryCommand implements Command {
    private final Inventory inventory;

    public InventoryCommand(Inventory inventory) {
        this.inventory = inventory;
    }

    @Override
    public Result execute() {
        System.out.println("Inventar:");

        // Zbrane
        Console.printColorMessage(" Zbrane:", Colors.CYAN);
        for (Weapon weapon : inventory.getWeapons()) {
            Console.printColorMessage("  " + weapon.toString(), Colors.CYAN);
        }

        // Mineraly
        Console.printColorMessage(" Mineraly:", Colors.YELLOW);
        Console.printColorMessage("  Nitra: " + inventory.getNitraAmount(), Colors.YELLOW);
        Console.printColorMessage("  Zlato: " + inventory.getGoldAmount(), Colors.YELLOW);
        Console.printColorMessage("  Morkite: " + inventory.getMorkiteAmount(), Colors.YELLOW);

        System.out.println();
        Console.printEnter();

        return Result.CONTINUE;
    }
}
