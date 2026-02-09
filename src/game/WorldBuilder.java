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
     * Procesuje mistnosti v SaveData objektu a vraci hotovy objekt RoomManager
     * @param save
     * @return
     */
    public RoomManager buildRooms(SaveData save) {
        RoomManager roomManager = new RoomManager();
        // Staveni kazde mistnosti
        for (RoomData room : save.getRooms()) {
            // Postavime mapu ze SaveData
            List<String> tiles = room.getMap().getTiles();
            int numRows = tiles.size();
            int numCol = tiles.get(0).length();
            Map newMap = new Map(numRows, numCol);

            for (int y = 0; y < numRows; y++) {
                //  Pro kazdy radek v SaveData
                String row = tiles.get(y);
                for (int x = 0; x < numCol; x++) {
                    // Pro kazdy char v radku
                    char letter = row.charAt(x);
                    MapObject mapObject = parseMapObjectFromChar(letter);
                    newMap.addMapObject(x, y, mapObject);
                }
            }

            // Prenastavime MapObjecty s overwrity
            for (OverwriteData overwrite : room.getMap().getOverwrites()) {
                // Ziskame info z overwritu
                overwriteType overwriteType = overwrite.getType();
                int x = overwrite.getPosition().getX();
                int y = overwrite.getPosition().getY();

                // Dle typu overwritu, zjistime co je treba extrahovat a vytvorime spravny MapObject
                MapObject newMapObject = parseMapObjectFromOverwrite(overwrite);
                newMap.addMapObject(x, y, newMapObject);
            }
            roomManager.addRoom(new Room(newMap, room.getRoomID(), room.getName(), room.getDescription()));
        }
        return roomManager;
    }

    /**
     * Stavi hrace z SaveData objektu a vraci objekt Player
     * @param save Objekt SaveData
     * @return Player player
     */
    public Player buildPlayer(SaveData save) {
        // Setup
        PlayerData playerData = save.getPlayer();
        Player newPlayer = new Player();

        // Nastavit zivoty
        newPlayer.setHealth(playerData.getHealth());

        // Nacist zbrane
        InventoryData inventoryData = playerData.getInventory();
        for (WeaponData weaponData : inventoryData.getWeapons()) {
            String weaponName = weaponData.getName();
            int range = weaponData.getRange();
            int damage = weaponData.getDamage();
            int weaponConsumption = weaponData.getAmmoConsumption();

            Weapon newWeapon = new Weapon(weaponName, range, damage, weaponConsumption);
            newPlayer.getInventory().addWeapon(newWeapon);
        }

        // Nacist mineraly
        newPlayer.getInventory().setGoldAmount(inventoryData.getGold());
        newPlayer.getInventory().setMorkiteAmount(inventoryData.getMorkite());
        newPlayer.getInventory().setNitraAmount(inventoryData.getNitra());

        // Nacist pozici
        String actualRoomID = playerData.getPosition().getActualRoomID();
        int x = playerData.getPosition().getX();
        int y = playerData.getPosition().getY();

        newPlayer.setActualRoomID(actualRoomID);
        newPlayer.setX(x);
        newPlayer.setY(y);

        return newPlayer;
    }

    /**
     * Postavi hrace do spravne mistnosti
     * @param roomManager RoomManager objekt
     * @param player Player
     */
    public void placePlayer(RoomManager roomManager, Player player) {
        String actualRoomID = player.getActualRoomID();
        int x = player.getX();
        int y = player.getY();

        // Jdeme skrz vsechny mistnosti dokud hracovo ID mistnosti je stejne a vlozime hrace do spravne mistnosti
        for (Room room : roomManager.getRooms()) {
            if (room.getRoomID().equals(actualRoomID)) {
                room.getMap().addMapObject(x, y, player);
            }
        }
    }

    /**
     * Vraci spravny defaultni MapObject (dvere, nepritel, hrac...) z charu (ikonky)
     * @param letter Char pismenko
     * @return MapObject
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
            case 'X':
                return mapObject = new EscapeRocket();
            default:
                throw new IllegalArgumentException("V .json souboru je neznamy charakter: " + letter);
        }
    }

    /**
     * Vraci zprocesovany Mapobject z overwritu
     * @param overwrite OverwriteData
     * @return MapObject
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
