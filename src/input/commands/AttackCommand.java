package input.commands;

import entities.Enemy;
import entities.Player;
import game.Console;
import input.Command;
import inventory.items.Weapon;
import map.Map;
import map.MapObject;
import worldObjects.Floor;

public class AttackCommand implements Command {
    private final int x;
    private final int y;
    private final Map map;
    private final Player player;

    public AttackCommand(int x, int y, Map map, Player player) {
        this.x = x;
        this.y = y;
        this.map = map;
        this.player = player;
    }

    @Override
    public void execute() {
        // Jsou souradnice validni
        if (y < 0 || y >= map.getMap().length || x < 0 || x >= map.getMap()[0].length) {
            System.out.println("Nespravne souradnice");
            Console.printEnter();
            return;
        }

        // Je zde nepritel
        MapObject mapObject = map.getMapObject(y, x);
        if (!(mapObject instanceof Enemy)) {
            System.out.println("Zde neni nepritel");
            Console.printEnter();
            return;
        }

        Enemy target = (Enemy) mapObject;

        // Ma hrac vybranou primarni zbran
        String activeWeaponID = player.getInventory().getActiveWeaponID();
        if (activeWeaponID == null) {
            System.out.println("Nemas vybranou primarni zbran");
            Console.printEnter();
            return;
        }
        Weapon activeWeapon = player.getInventory().getActiveWeapon();

        // Zjisti vzdalenost
        int dx = Math.abs(player.getX() - x);
        int dy = Math.abs(player.getY() - y);
        int distance = Math.max(dx, dy);

        if (distance > activeWeapon.getRange()) {
            System.out.println("Nepratel je mimo dosah");
            Console.printEnter();
            return;
        }

        // Ma hrac dostatek munice
        if (activeWeapon.getAmmoConsumption() > 0) {
            if (player.getInventory().getAmmo() < activeWeapon.getAmmoConsumption()) {
                System.out.println("Nemas dostatek munice");
                Console.printEnter();
                return;
            }
        }

        // Zautoceni na nepratele
        target.takeDamage(activeWeapon.getDamage());
        System.out.println("Zasahnul si nepritele za: " + activeWeapon.getDamage() + " damage");
        player.getInventory().setAmmo(player.getInventory().getAmmo() - activeWeapon.getAmmoConsumption());

        // Pripadne odstranit nepratele
        if (!target.isAlive()) {
            map.addMapObject(y, x, new Floor());
            System.out.println("Nepritel znicen");
        }
        Console.printEnter();
    }

}
