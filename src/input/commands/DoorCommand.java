package input.commands;

import entities.Player;
import game.Console;
import input.Command;
import map.Map;
import map.MapObject;
import rooms.RoomManager;
import worldObjects.Door;
import worldObjects.Floor;

/**
 * DoorCommand zpracuje pohyb z mistnosti do mistnosti pomoci objektu Door v mape
 */
public class DoorCommand implements Command {
    private final int x;
    private final int y;
    private final RoomManager roomManager;
    private final Player player;

    public DoorCommand(String[] args, RoomManager roomManager, Player player) {
        this.x = Integer.parseInt(args[0]);
        this.y = Integer.parseInt(args[1]);
        this.roomManager = roomManager;
        this.player = player;
    }

    public void execute() {
        Map map = roomManager.getRoomByID(player.getActualRoomID()).getMap();

        // Jsou souradnice validni
        if (!map.isValidCoordinate(x, y)) {
            Console.printError("Nespravne souradnice");
            return;
        }

        // Zjistime vzdálenost mezi hracem a dvermi
        int dx = Math.abs(player.getX() - x);
        int dy = Math.abs(player.getY() - y);

        // Pokud neni dost blizko
        if (dx > 1 || dy > 1) {
            Console.printError("Jsi moc daleko od dveri");
            return;
        }

        // Zkontrolujeme jestli mapObject jsou doopravdy dvere
        MapObject mapObject = map.getMapObject(y, x);
        if (!(mapObject instanceof Door)) {
            Console.printError("Zde nejsou dvere");
            return;
        }

        Door door = (Door) mapObject;

        // Najdeme novou mapu podle targetRoomID
        Map newMap = roomManager.getRoomByID(door.getTargetRoomID()).getMap();

        // Odstranime hrace ze stare mapy
        map.addMapObject(player.getY(), player.getX(), new Floor());

        // Ziskame target souradnice z dveri
        int targetX = door.getTargetX();
        int targetY = door.getTargetY();

        // Presuneme hrace do nove mapy
        newMap.addMapObject(targetY, targetX, player);

        // Aktualizujeme hrace a roomManager
        player.setActualRoomID(door.getTargetRoomID());
        player.setX(targetX);
        player.setY(targetY);
        roomManager.setCurrentRoomID(door.getTargetRoomID());
    }

}
