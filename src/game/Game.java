package game;

import entities.Player;
import input.Command;
import input.InputHandler;
import input.commands.EndCommand;
import rooms.RoomManager;
import save.SaveData;

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
    public Game() {
        isRunning = true;
        saveManager = new SaveManager();
        worldBuilder = new WorldBuilder();
        inputHandler = new InputHandler();
    }

    public void runGame() {
        // Pripraveni
        SaveData save = saveManager.loadGame("resources/save.json");
        roomManager = worldBuilder.buildRooms(save);
        player = worldBuilder.buildPlayer(save);
        worldBuilder.placePlayer(roomManager, player);

        // TODO dokoncit hlavni herni smycku
        // TODO zhezcit printovani do konzole

        // Hlavni herni smycka
        while (isRunning) {
            // Printeni zakladnich udaju a mapy
            Console.printSpace();
            Console.printColorMessage(
                    "Zivoty: " + player.getHealth() + " | " +
                    "Naboje: " + player.getInventory().getAmmo() + " | " +
                    "Aktivni zbran: " + player.getInventory().getActiveWeaponID(), Colors.RED);
            Console.printColorMessage("Aktivni mistnost >> " + roomManager.getCurrentRoom().getName(), Colors.YELLOW);
            roomManager.printActiveRoom();

            // Parzovani vstupu a hlavni smycka
            Console.printColorMessage("Vstup ==>>                   (pro list komandu: ,,help'')", Colors.GREEN);
            String input = Console.getInputFromUser();
            Command command = inputHandler.parseCommand(input, player, roomManager);
            if (command != null) {
                if (command instanceof EndCommand) {
                    Console.printColorMessage("Konec hry!", Colors.GREEN);
                    isRunning = false;
                    break;
                }
                command.execute();
            } else {
                Console.printError("Nespravny komand");
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
