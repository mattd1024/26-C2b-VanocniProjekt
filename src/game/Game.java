package game;

import entities.Player;
import rooms.RoomManager;
import save.SaveData;

public class Game {
    private boolean isRunning;
    private Player player;
    private RoomManager roomManager;
    private SaveManager saveManager;
    private WorldBuilder worldBuilder;

    public Game() {
        isRunning = true;
        saveManager = new SaveManager();
        worldBuilder = new WorldBuilder();
    }

    public void runGame() {
        // Setup
        SaveData save = saveManager.loadGame("resources/save.json");
        roomManager = worldBuilder.buildRooms(save);
        player = worldBuilder.buildPlayer(save);
        worldBuilder.placePlayer(roomManager, player);

        //TODO add main game loop
    }

    public void test() {
        roomManager.getRooms().get(0).getMap().printMap();
        System.out.println();
        roomManager.getRooms().get(1).getMap().printMap();
        System.out.println();
        roomManager.getRooms().get(2).getMap().printMap();
        System.out.println();
        roomManager.getRooms().get(3).getMap().printMap();
        System.out.println();
        roomManager.getRooms().get(4).getMap().printMap();
        System.out.println();
        roomManager.getRooms().get(5).getMap().printMap();
        System.out.println();
        roomManager.getRooms().get(6).getMap().printMap();
        System.out.println();
        roomManager.getRooms().get(7).getMap().printMap();
        System.out.println();
    }


}
