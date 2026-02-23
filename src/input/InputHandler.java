package input;

import entities.Player;
import input.commands.*;
import inventory.Inventory;
import map.Map;
import rooms.RoomManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputHandler {
    /**
     * Parzuje string input a vraci apropriatni komand objekt s parametrama
     * @param input String input
     * @param player Player player
     * @param roomManager RoomManager roomManager
     * @return Command
     */
    public Command parseCommand(String input, Player player, RoomManager roomManager) {
        // Osetrime input
        if (input == null) {
            return null;
        }
        input = input.trim().toLowerCase();

        // Rozdelime input dle mezer: na prvni slovo keyword, a na jednotlive casti parts
        String[] parts = input.split("\\s+");
        String keyword = parts[0];

        // Pripravime potrebne argumenty aby mohly byt predany komandum
        Map map = roomManager.getCurrentRoom().getMap();
        Inventory inventory = player.getInventory();

        // Vytahneme z parts argumenty, ty budeme predavat komandum
        String[] args = Arrays.copyOfRange(parts, 1, parts.length);

        // Procesujeme dalsi komandy
        switch(keyword) {
            case "attack":
                if (validateArgsLength(args, 2) && validateArgsInt(args)) {
                    return new AttackCommand(args, roomManager.getCurrentRoom(), player);
                }
                break;
            case "collect":
                if (validateArgsLength(args, 2) && validateArgsInt(args)) {
                    return new CollectCommand(args, player, map);
                }
                break;
            case "door":
                if (validateArgsLength(args, 2) && validateArgsInt(args)) {
                    return new DoorCommand(args, roomManager, player);
                }
                break;
            case "end":
                return new EndCommand();
            case "explore":
                if (validateArgsLength(args, 2) && validateArgsInt(args)) {
                    return new ExploreCommand(args, map);
                }
                break;
            case "help":
                return new HelpCommand();
            case "inventory":
                return new InventoryCommand(inventory);
            case "mine":
                if (validateArgsLength(args, 2) && validateArgsInt(args)) {
                    return new MineCommand(args, map, player);
                }
                break;
            case "resupply":
                if (validateArgsLength(args, 2) && validateArgsInt(args)) {
                    return new ResupplyCommand(args, inventory, map);
                }
                break;
            case "room":
                return new RoomCommand(roomManager, player);
            case "setweapon":
                if (validateArgsLength(args, 1)) {
                    return new SetWeaponCommand(args, inventory);
                }
                break;
            case "talk":
                if (validateArgsLength(args, 2) && validateArgsInt(args)) {
                    return new TalkCommand(args, map, player);
                }
                break;
            case "escape":
                if (validateArgsLength(args, 2) && validateArgsInt(args)) {
                    return new EscapeCommand(args, map, player);
                }
                break;
        }

        // Zkusime jestli je komand typu pohybu (ma specialni syntax bez argumentu [napr.: add, was, dd, s] a mel by se zpracovat odlisneji nez ostatni)
        Command move = parseMove(keyword, player, map);
        if (move != null) {
            return move;
        }

        // Zadny komand neprosel
        return null;
    }

    /**
     * Separatne parzuje komand pohybu a vraci MoveCommand
     * @param input String input
     * @param player Player player
     * @param map Map map
     * @return Command
     */
    public MoveCommand parseMove(String input, Player player, Map map) {
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

    /**
     * Projde args[] a zjisti jestli je vsechno v nem int
     * @param args String args[]
     * @return True/false
     */
    public boolean validateArgsInt(String[] args) {
        for (String arg : args) {
            try {
                Integer.parseInt(arg);
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return true;
    }

    /**
     * Verifikuje jestli args[] velikost odpovida potrebnemu poctu
     * @param args String[] args
     * @param expectedCount Int ocekavana velikost
     * @return True/false
     */
    public boolean validateArgsLength(String[] args, int expectedCount) {
        if (args.length != expectedCount) {
            return false;
        }
        return true;
    }
}
