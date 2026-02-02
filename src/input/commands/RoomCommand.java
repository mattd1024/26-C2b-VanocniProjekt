package input.commands;

import entities.Player;
import game.Console;
import input.Command;
import map.Map;
import rooms.Room;
import rooms.RoomManager;

public class RoomCommand implements Command {
    private final RoomManager roomManager;
    private final Player player;

    public RoomCommand(RoomManager roomManager, Player player) {
        this.roomManager = roomManager;
        this.player = player;
    }

    @Override
    public void execute() {
        // Vyprintime nazev a deskripci mistnosti ve ktere je hrac
        Room actualRoom = roomManager.getRoomByID(player.getActualRoomID());
        System.out.println("Jsi v mistnosti: " + actualRoom.getName());
        System.out.println("    " + actualRoom.getDescription());
        Console.printEnter();

    }
}
