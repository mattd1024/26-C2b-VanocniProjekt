package input.commands;

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
    public void execute() {
        System.out.println("Inventar: ");
        System.out.println("    Zbrane::");
        for (Weapon weapon : inventory.getWeapons()) {
            System.out.print("      "+weapon.toString());
        }
        System.out.println();
        System.out.println("    Mineraly:");
        System.out.print("        Nitra: "+inventory.getNitraAmount()+" | Gold: "+inventory.getGoldAmount()+" | Morkite: "+inventory.getMorkiteAmount());
        System.out.println();
        Console.printEnter();
    }
}
