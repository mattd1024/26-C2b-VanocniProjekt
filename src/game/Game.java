package game;

import entities.Player;
import input.Command;
import input.InputHandler;
import input.commands.EndCommand;
import rooms.RoomManager;
import save.SaveData;

import java.util.Scanner;

/**
 * Trida Game sjednocuje vsechny herni funkce a obsahuje hlavni herni smycku
 */
public class Game {
    private boolean isRunning;
    private Player player;
    private RoomManager roomManager;
    private SaveManager saveManager;
    private WorldBuilder worldBuilder;
    private InputHandler inputHandler;
    private Scanner scanner;

    public Game() {
        isRunning = true;
        saveManager = new SaveManager();
        worldBuilder = new WorldBuilder();
        inputHandler = new InputHandler();
        scanner = new Scanner(System.in);
    }

    public void runGame() {
        // Setup
        SaveData save = saveManager.loadGame("resources/save.json");
        roomManager = worldBuilder.buildRooms(save);
        player = worldBuilder.buildPlayer(save);
        worldBuilder.placePlayer(roomManager, player);

        // TODO dokoncit hlavni herni smycku
        // TODO zhezcit printovani do konzole
        // TODO sjednotit jazyk
        // Main game loop
        while (isRunning) {
            roomManager.printActiveRoom();

            String input;
            System.out.println("Vstup ==>                     (pro list komandu: ,,help'')");
            input = scanner.nextLine();
            Command command = inputHandler.parseCommand(input, player, roomManager);
            if (command != null) {
                if (command instanceof EndCommand) {
                    System.out.println("Ending game!");
                    isRunning = false;
                    break;
                }
                command.execute();
            } else {
                System.out.println("Nespravny komand");
            }
        }
    }

    public void test() {
//        roomManager.getRooms().get(0).getMap().printMap();
//        System.out.println();
//        roomManager.getRooms().get(1).getMap().printMap();
//        System.out.println();
//        roomManager.getRooms().get(2).getMap().printMap();
//        System.out.println();
//        roomManager.getRooms().get(3).getMap().printMap();
//        System.out.println();
//        roomManager.getRooms().get(4).getMap().printMap();
//        System.out.println();
//        roomManager.getRooms().get(5).getMap().printMap();
//        System.out.println();
//        roomManager.getRooms().get(6).getMap().printMap();
//        System.out.println();
//        roomManager.getRooms().get(7).getMap().printMap();
//        System.out.println();
    }





}
