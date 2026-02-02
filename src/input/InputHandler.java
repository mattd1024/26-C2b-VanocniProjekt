package input;

import entities.Player;
import game.Game;
import input.commands.*;
import map.Map;
import rooms.RoomManager;
import worldObjects.Door;

import java.util.ArrayList;
import java.util.List;

public class InputHandler {
    public Command parseCommand(String input, Player player, Map map, RoomManager roomManager) {
        // Osetrime input
        if (input == null) {
            return null;
        }
        input = input.trim().toLowerCase();

        // Rozdelime input dle mezer
        String[] parts = input.split("\\s+");
        String keyword = parts[0];

        // Procesneme vstup a vratime spravny Command objekt
        Command move = parseMove(keyword, player, map);
        if (move != null) {
            return move;
        }
        switch(keyword) {
            case "attack":
                return new AttackCommand(Integer.parseInt(parts[1]), Integer.parseInt(parts[2]), map, player);
            case "collect":
                return new CollectCommand(Integer.parseInt(parts[1]), Integer.parseInt(parts[2]), player, map);
            case "door":
                return new DoorCommand(Integer.parseInt(parts[1]), Integer.parseInt(parts[2]), roomManager, player);
            case "end":
                return new EndCommand();
            case "explore":
                return new ExploreCommand(Integer.parseInt(parts[1]), Integer.parseInt(parts[2]), map);
            case "help":
                return new HelpCommand();
            case "inventory":
                return new InventoryCommand(player.getInventory());
            case "mine":
                return new MineCommand(Integer.parseInt(parts[1]), Integer.parseInt(parts[2]), map, player);
            case "resupply":
                return new ResupplyCommand(Integer.parseInt(parts[1]), Integer.parseInt(parts[2]), player.getInventory(), map);
            case "room":
                return new RoomCommand(roomManager, player);
            case "setweapon":
                return new SetWeaponCommand(parts[1], player.getInventory());
            case "talk":
                return new TalkCommand(Integer.parseInt(parts[1]), Integer.parseInt(parts[2]), map, player);
            default:
                return null;
        }
    }

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
