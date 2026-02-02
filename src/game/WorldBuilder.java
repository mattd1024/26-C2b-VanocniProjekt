package game;

import entities.Enemy;
import entities.Friendly;
import entities.Player;
import entities.ShopBot;
import inventory.items.Weapon;
import map.Map;
import map.MapObject;
import rooms.Room;
import rooms.RoomManager;
import save.SaveData;
import save.overwriteType;
import save.savedData.*;
import worldObjects.*;

import java.util.List;

import static worldObjects.OreNode.MineralType.*;

public class WorldBuilder {
    SaveManager saveManager;

    public WorldBuilder() {
        saveManager = new SaveManager();
    }

    /**
     * Process the rooms in SaveData and return a finished RoomManager
     * @param save
     * @return
     */
    public RoomManager buildRooms(SaveData save) {
        RoomManager roomManager = new RoomManager();
        // Process each room
        for (RoomData room : save.getRooms()) {
            // Build the map from the .json file
            List<String> tiles = room.getMap().getTiles();
            int numRows = tiles.size();
            int numCol = tiles.get(0).length();
            Map newMap = new Map(numRows, numCol);

            for (int y = 0; y < numRows; y++) { // For every row in json
                String row = tiles.get(y);
                for (int x = 0; x < numCol; x++) { // For every char in row
                    char letter = row.charAt(x);
                    MapObject mapObject = parseMapObjectFromChar(letter);
                    newMap.addMapObject(y, x, mapObject);
                }
            }

            // Overwrite map objects with overwrites
            for (OverwriteData overwrite : room.getMap().getOverwrites()) {
                // Get general info from overwrite
                overwriteType overwriteType = overwrite.getType();
                int x = overwrite.getPosition().getX();
                int y = overwrite.getPosition().getY();

                // Based on the type of overwrite, find out whats needed to extract and create a corresponding MapObject
                MapObject newMapObject = parseMapObjectFromOverwrite(overwrite);
                newMap.addMapObject(y, x, newMapObject);
            }
            roomManager.addRoom(new Room(newMap, room.getRoomID(), room.getName(), room.getDescription()));
        }
        return roomManager;
    }

    public Player buildPlayer(SaveData save) {
        // Setup
        PlayerData playerData = save.getPlayer();
        Player newPlayer = new Player();

        // Set health
        newPlayer.setHealth(playerData.getHealth());

        // Load weapons
        InventoryData inventoryData = playerData.getInventory();
        for (WeaponData weaponData : inventoryData.getWeapons()) {
            String weaponName = weaponData.getName();
            int range = weaponData.getRange();
            int damage = weaponData.getDamage();
            int weaponConsumption = weaponData.getAmmoConsumption();

            Weapon newWeapon = new Weapon(weaponName, range, damage, weaponConsumption);
            newPlayer.getInventory().addWeapon(newWeapon);
        }

        // Load minerals
        newPlayer.getInventory().setGoldAmount(inventoryData.getGold());
        newPlayer.getInventory().setMorkiteAmount(inventoryData.getMorkite());
        newPlayer.getInventory().setNitraAmount(inventoryData.getNitra());

        // Load position
        String actualRoomID = playerData.getPosition().getActualRoomID();
        int x = playerData.getPosition().getX();
        int y = playerData.getPosition().getY();

        newPlayer.setActualRoomID(actualRoomID);
        newPlayer.setX(x);
        newPlayer.setY(y);

        return newPlayer;
    }

    public void placePlayer(RoomManager roomManager, Player player) {
        // Put player in map
        String actualRoomID = player.getActualRoomID();
        int x = player.getX();
        int y = player.getY();

        // Loop through rooms until room IDs match and place player in the room
        for (Room room : roomManager.getRooms()) {
            if (room.getRoomID().equals(actualRoomID)) {
                room.getMap().addMapObject(y, x, player);
            }
        }
    }

    /**
     * Returns the appropriate MapObject (door, enemy, player...) from a letter (icon)
     * @param letter
     * @return
     */
    public MapObject parseMapObjectFromChar(char letter) {
        MapObject mapObject;
        switch (letter) {
            case '·':
                return mapObject = new Floor();
            case '#':
                return mapObject = new Wall();
            case 'E':
                return mapObject = new Enemy();
            case 'S':
                return mapObject = new ShopBot();
            case 'P':
                return mapObject = new Player();
            case 'N':
                return mapObject = new OreNode(NITRA);
            case 'G':
                return mapObject = new OreNode(GOLD);
            case 'M':
                return mapObject = new OreNode(MORKITE);
            case 'R':
                return mapObject = new Resupply(100, 100);
            case 'D':
                return mapObject = new Door();
            case 'F':
                return mapObject = new Friendly();
            default:
                throw new IllegalArgumentException("Unknown map character in .json save file: " + letter);
        }
    }

    /**
     * Returns a processed MapObject from an overwrite
     * @param overwrite
     * @return
     */
    public MapObject parseMapObjectFromOverwrite(OverwriteData overwrite) {
        MapObject newMapObject;
        overwriteType overwriteType = overwrite.getType();
        switch(overwriteType) {
            case ENEMY:
                int health = (int)(double) (overwrite.getState().get("health"));
                return newMapObject = new Enemy(health);
            case DOOR:
                String targetRoomID = overwrite.getState().get("targetRoomID").toString();
                int targetX = (int)(double) overwrite.getState().get("targetX");
                int targetY = (int)(double) overwrite.getState().get("targetY");
                return newMapObject = new Door(targetRoomID, targetX, targetY);
            case ORENODE:
                OreNode.MineralType mineralType = OreNode.MineralType.valueOf(overwrite.getState().get("mineralType").toString());
                int amountOfOre = (int)(double) overwrite.getState().get("amountOfOre");
                return newMapObject = new  OreNode(amountOfOre, mineralType);
            case FRIENDLY:
                String name = overwrite.getState().get("name").toString();
                String message = overwrite.getState().get("message").toString();
                return newMapObject = new Friendly(name, message);
            default:
                throw new  IllegalArgumentException("Unknown overwrite type in .json save file");
        }
    }
}
