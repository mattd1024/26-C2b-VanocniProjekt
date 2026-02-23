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

    public void setUp() {
        // Pripraveni
        SaveData save = saveManager.loadGame("resources/save.json");
        roomManager = worldBuilder.buildRooms(save);
        player = worldBuilder.buildPlayer(save);
        worldBuilder.placePlayer(roomManager, player);
    }

    public void runGame() {
        // Pripravit hru
        setUp();

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

            // Parzovani vstupu
            Console.printColorMessage("Vstup ==>>                   (pro list komandu: ,,help'')", Colors.GREEN);
            String input = Console.getInputFromUser();
            Command command = inputHandler.parseCommand(input, player, roomManager);

            if (command == null) {
                Console.printError("Nespravny komand");
                continue;
            }

            // Dle vysledku komandu (vraci enum: END_GAME | END_TURN | CONTINUE) se provede akce
            Command.Result result = command.execute();
            if (result != null) {
                switch (result) {
                    case END_TURN:
                        // Pro kazdeho nepritele v mistnosti udelat jeho turn
                        roomManager.getCurrentRoom().startEnemies(player);

                        // Po akci nepratel zkontrolujeme jestli je hrac mrtev
                        if (!player.isAlive()) {
                            Console.printColorMessage("Zemrel jsi!", Colors.RED);
                            Console.printEnter();
                            isRunning = false;
                        }
                        break;
                    case CONTINUE:
                        break;
                    case END_GAME:
                        isRunning = false;
                        break;
                }
            }
        }
    }
}
