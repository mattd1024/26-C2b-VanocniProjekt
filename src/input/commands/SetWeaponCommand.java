package input.commands;

import input.Command;
import inventory.Inventory;
import inventory.items.Weapon;

public class SetWeaponCommand implements Command {
    private final String requestedWeapon;
    private final Inventory inventory;

    public SetWeaponCommand(String requestedWeapon, Inventory inventory) {
        this.requestedWeapon = requestedWeapon;
        this.inventory = inventory;
    }

    @Override
    public void execute() {
        // Zjistime jestli ma hrac zbran podle nazvu zbrane a pripadne nastavime jako primarni zbran hrace
        for (Weapon weapon : inventory.getWeapons()) {
            if (weapon.getName().toLowerCase().equals(requestedWeapon)) {
                inventory.setActiveWeapon(weapon.getName());
            } else {
                System.out.println("Tuto zbran nemas");
            }
        }
    }
}
