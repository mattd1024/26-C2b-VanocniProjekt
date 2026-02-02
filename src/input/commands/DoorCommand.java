package input.commands;

import entities.Player;
import game.Console;
import input.Command;
import map.Map;
import map.MapObject;
import rooms.RoomManager;
import worldObjects.Door;
import worldObjects.Floor;

public class DoorCommand implements Command {
    private final int x;
    private final int y;
    private final RoomManager roomManager;
    private final Player player;

    public DoorCommand(int x, int y, RoomManager roomManager, Player player) {
        this.x = x;
        this.y = y;
        this.roomManager = roomManager;
        this.player = player;
    }

    public void execute() {
        // Jsou souradnice validni
        Map map = roomManager.getRoomByID(player.getActualRoomID()).getMap();
        if (y < 0 || y >= map.getMap().length || x < 0 || x >= map.getMap()[0].length) {
            System.out.println("Nespravne souradnice");
            Console.printEnter();
            return;
        }

        // Zjistime vzdálenost mezi hracem a dvermi
        int dx = Math.abs(player.getX() - x);
        int dy = Math.abs(player.getY() - y);

        // Pokud neni dost blizko
        if (dx > 1 || dy > 1) {
            System.out.println("Jsi moc daleko od dveri");
            Console.printEnter();
            return;
        }

        // Zkontrolujeme jestli mapObject jsou doopravdy dvere
        MapObject mapObject = map.getMapObject(y, x);
        if (!(mapObject instanceof Door)) {
            System.out.println("Zde nejsou dvere");
            Console.printEnter();
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

        // Overime, ze cilove souradnice nejsou mimo mapu
        if (targetY < 0 || targetY >= newMap.getMap().length || targetX < 0 || targetX >= newMap.getMap()[0].length) {
            System.out.println("Cilove souradnice dveri jsou mimo mapu!");
            return;
        }

        // Presuneme hrace do nove mapy
        newMap.addMapObject(targetY, targetX, player);

        // Aktualizujeme hrace a roomManager
        player.setActualRoomID(door.getTargetRoomID());
        player.setX(targetX);
        player.setY(targetY);
        roomManager.setCurrentRoomID(door.getTargetRoomID());
    }

}
