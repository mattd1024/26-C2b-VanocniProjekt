import entities.Player;
import game.Game;
import game.SaveManager;
import game.WorldBuilder;
import input.Command;
import input.InputHandler;
import input.commands.CollectCommand;
import input.commands.DoorCommand;
import input.commands.MoveCommand;
import input.commands.ResupplyCommand;
import inventory.Inventory;
import inventory.items.Weapon;
import map.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rooms.Room;
import rooms.RoomManager;
import save.SaveData;
import worldObjects.OreNode;

import static org.junit.jupiter.api.Assertions.*;

public class test {
    Player player;
    Inventory inventory;
    InputHandler inputHandler;
    RoomManager roomManager;
    SaveManager saveManager;
    WorldBuilder worldBuilder;

    @BeforeEach
    void setUp() {
        player = new Player(100, new Inventory());
        inventory = player.getInventory();
        inputHandler = new InputHandler();
        roomManager = new RoomManager();
        saveManager = new SaveManager();
        worldBuilder = new WorldBuilder();

        SaveData save = saveManager.loadGame("resources/save.json");
        roomManager = worldBuilder.buildRooms(save);
        player = worldBuilder.buildPlayer(save);
        worldBuilder.placePlayer(roomManager, player);
    }

    @Test
    void setActiveWeaponTest() {
        inventory.addWeapon(new Weapon("Pistole", 2, 50, 2));
        inventory.setActiveWeapon("Pistole");

        assertEquals("Pistole", inventory.getActiveWeaponID());
    }

    @Test
    void addMineralTest() {
        inventory.addMineral(OreNode.MineralType.NITRA, 80);

        assertEquals(80, inventory.getNitraAmount());
    }

    @Test
    void killPlayerTest() {
        player.takeDamage(Integer.MAX_VALUE);
        assertFalse(player.isAlive());
    }

    @Test
    void unknownCommandTest() {
        assertNull(doCommand("jablecny dzus"));
    }

    @Test
    void doorCommandInputHandlerTest() {
        Command command = doCommand("door 9 2");

        assertInstanceOf(DoorCommand.class, command);
    }

    @Test
    void moveCommandInputHandlerTest() {
        Command command = doCommand("das");

        assertInstanceOf(MoveCommand.class, command);
    }

    @Test
    void moveToRoom02Test() {
        MoveCommand moveCommand = (MoveCommand) doCommand("d");
        for (int i = 0 ; i < 8 ; i++) {
            moveCommand.execute();
        }

        DoorCommand doorCommand = (DoorCommand) doCommand("door 9 2");
        doorCommand.execute();

        assertEquals("room02", roomManager.getCurrentRoomID());
    }

    @Test
    void collectCommandTest() {
        ResupplyCommand resupplyCommand = (ResupplyCommand) doCommand("resupply 0 1");
        resupplyCommand.execute();

        player.takeDamage(player.getMAX_HEALTH() - 1);

        CollectCommand collectCommand = (CollectCommand) doCommand("collect 0 1");
        collectCommand.execute();

        assertEquals(player.getMAX_HEALTH(), player.getHealth());
    }

    public Command doCommand(String input) {
        return inputHandler.parseCommand(input, player, roomManager);
    }
}
