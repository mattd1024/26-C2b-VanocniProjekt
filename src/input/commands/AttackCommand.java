package input.commands;

import entities.Enemy;
import entities.Player;
import game.Colors;
import game.Console;
import input.Command;
import inventory.items.Weapon;
import map.Map;
import map.MapObject;
import worldObjects.Floor;

import java.util.List;

/**
 * AttackCommand spravuje utok hrace na nepritele
 */
public class AttackCommand implements Command {
    private final int x;
    private final int y;
    private final Map map;
    private final Player player;

    public AttackCommand(String[] args, Map map, Player player) {
        this.x = Integer.parseInt(args[0]);
        this.y = Integer.parseInt(args[1]);
        this.map = map;
        this.player = player;
    }

    @Override
    public void execute() {
        // Jsou souradnice validni
        if (!map.isValidCoordinate(x, y)) {
            Console.printError("Nespravne souradnice");
            return;
        }

        // Je zde nepritel
        MapObject mapObject = map.getMapObject(y, x);
        if (!(mapObject instanceof Enemy)) {
            Console.printError("Zde neni nepritel");
            return;
        }

        Enemy target = (Enemy) mapObject;

        // Ma hrac vybranou primarni zbran
        String activeWeaponID = player.getInventory().getActiveWeaponID();
        if (activeWeaponID == null) {
            Console.printError("Nemas vybranou primarni zbran");
            return;
        }
        Weapon activeWeapon = player.getInventory().getActiveWeapon();

        // Zjisti vzdalenost
        int dx = Math.abs(player.getX() - x);
        int dy = Math.abs(player.getY() - y);
        int distance = Math.max(dx, dy);

        if (distance > activeWeapon.getRange()) {
            Console.printError("Nepritel je mimo dosah");
            return;
        }

        // Ma hrac dostatek munice
        if (activeWeapon.getAmmoConsumption() > 0) {
            if (player.getInventory().getAmmo() < activeWeapon.getAmmoConsumption()) {
                Console.printError("Nemas dostatek munice");
                return;
            }
        }

        // Zautoceni na nepratele
        target.takeDamage(activeWeapon.getDamage());
        Console.printColorMessage("Zasahnul si nepritele za: " + activeWeapon.getDamage() + " damage", Colors.RED);
        player.getInventory().setAmmo(player.getInventory().getAmmo() - activeWeapon.getAmmoConsumption());

        // Pripadne odstranit nepratele
        if (!target.isAlive()) {
            map.addMapObject(y, x, new Floor());
            System.out.println("Nepritel znicen");
            Console.printColorMessage("Nepritel znicen!", Colors.RED);
            Console.printEnter();
        }
        Console.printEnter();
    }

}
