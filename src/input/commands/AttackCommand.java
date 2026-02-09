package input.commands;

import entities.Enemy;
import entities.Player;
import game.Colors;
import game.Console;
import input.Command;
import inventory.items.Weapon;
import map.Map;
import map.MapHelper;
import map.MapObject;
import rooms.Room;
import worldObjects.Floor;

/**
 * AttackCommand spravuje utok hrace na nepritele
 */
public class AttackCommand implements Command {
    private final int x;
    private final int y;
    private final Room room;
    private final Player player;

    public AttackCommand(String[] args, Room room, Player player) {
        this.x = Integer.parseInt(args[0]);
        this.y = Integer.parseInt(args[1]);
        this.room = room;
        this.player = player;
    }

    @Override
    public Result execute() {
        Map map = room.getMap();

        // Jsou souradnice validni
        if (!MapHelper.isValidCoordinate(x, y, map.getWidth(), map.getHeight())) {
            Console.printError("Nespravne souradnice");
            return null;
        }

        // Je zde nepritel
        MapObject mapObject = map.getMapObject(x, y);
        if (!(mapObject instanceof Enemy)) {
            Console.printError("Zde neni nepritel");
            return null;
        }

        Enemy target = (Enemy) mapObject;

        // Ma hrac vybranou primarni zbran
        String activeWeaponID = player.getInventory().getActiveWeaponID();
        if (activeWeaponID == null) {
            Console.printError("Nemas vybranou primarni zbran");
            return null;
        }
        Weapon activeWeapon = player.getInventory().getActiveWeapon();

        // Zjisti vzdalenost
        int dx = Math.abs(player.getX() - x);
        int dy = Math.abs(player.getY() - y);
        int distance = Math.max(dx, dy);

        if (distance > activeWeapon.getRange()) {
            Console.printError("Nepritel je mimo dosah");
            return null;
        }

        // Ma hrac dostatek munice
        if (activeWeapon.getAmmoConsumption() > 0) {
            if (player.getInventory().getAmmo() < activeWeapon.getAmmoConsumption()) {
                Console.printError("Nemas dostatek munice");
                return null;
            }
        }

        // Zautoceni na nepratele
        target.takeDamage(activeWeapon.getDamage());
        Console.printColorMessage("Zasahnul si nepritele za: " + activeWeapon.getDamage() + " damage", Colors.RED);
        player.getInventory().setAmmo(player.getInventory().getAmmo() - activeWeapon.getAmmoConsumption());

        // Pripadne odstranit nepratele
        if (!target.isAlive()) {
            map.addMapObject(x, y, new Floor());
            room.removeEnemy(target);
//            Console.printColorMessage("Nepritel znicen!", Colors.RED);
//            Console.printEnter();
        }
        Console.printEnter();

        return Result.END_TURN;
    }

}
