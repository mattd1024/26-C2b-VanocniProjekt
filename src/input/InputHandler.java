package input;

import entities.Player;
import game.Game;
import input.commands.*;
import inventory.Inventory;
import map.Map;
import rooms.RoomManager;
import worldObjects.Door;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputHandler {
    /**
     * Parzuje string input a vraci apropriatni komand objekt s parametrama
     * @param input String input
     * @param player Player player
     * @param roomManager RoomManager roomManager
     * @return
     */
    public Command parseCommand(String input, Player player, RoomManager roomManager) {
        // Pripravime potrebne argumenty aby mohly byt predany komandum
        Map map = roomManager.getCurrentRoom().getMap();
        Inventory inventory = player.getInventory();

        // Osetrime input
        if (input == null) {
            return null;
        }
        input = input.trim().toLowerCase();

        // Rozdelime input dle mezer: na prvni slovo keyword, a na jednotlive casti parts
        String[] parts = input.split("\\s+");
        String keyword = parts[0];

        // Zkusime jestli je komand typu pohybu (ma specialni syntax bez argumentu [napr.: add, was, dd, s] a mel by se zpracovat drive nez ostatni)
        Command move = parseMove(keyword, player, map);
        if (move != null) {
            return move;
        }

        // Vytahneme z parts argumenty, ty budeme predavat komandum
        String[] args = Arrays.copyOfRange(parts, 1, parts.length);

            // Procesujeme dalsi komandy
        switch(keyword) {
            case "attack":
                return new AttackCommand(args, map, player);
            case "collect":
                return new CollectCommand(args, player, map);
            case "door":
                return new DoorCommand(args, roomManager, player);
            case "end":
                return new EndCommand();
            case "explore":
                return new ExploreCommand(args, map);
            case "help":
                return new HelpCommand();
            case "inventory":
                return new InventoryCommand(inventory);
            case "mine":
                return new MineCommand(args, map, player);
            case "resupply":
                return new ResupplyCommand(args, inventory, map);
            case "room":
                return new RoomCommand(roomManager, player);
            case "setweapon":
                return new SetWeaponCommand(args, inventory);
            case "talk":
                return new TalkCommand(args, map, player);
            default:
                return null;
        }
    }

    /**
     * Separatne parzuje komand pohybu a vraci MoveCommand
     * @param input String input
     * @param player Player player
     * @param map Map map
     * @return
     */
    public Command parseMove(String input, Player player, Map map) {
        // Zpracujeme move komand
        if ((input.length() <= 3) && (input.startsWith("w") || input.startsWith("a")  || input.startsWith("s") || input.startsWith("d"))) {
            List<Character> moves = new ArrayList<>(input.length());
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                if (c == 'w' || c == 'a' || c == 's' || c == 'd') {
                    moves.add(c);
                }
            }
            return new MoveCommand(player, moves, map);
        }
        return null;
    }
}
