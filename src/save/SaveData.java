package save;

import save.savedData.PlayerData;
import save.savedData.RoomData;

import java.util.List;

/**
 * SaveData reprezentuje jak by mel vypadat .json soubor
 * Umoznuje vybrani si toho co chci aby se ukladalo
 * Obsahuje dalsi jednotlive tridy reprezentujici json objekty vedle v package savedData
 * Pracuje s GSON
 */
public class SaveData {
    private List<RoomData> rooms;
    private PlayerData player;

    public SaveData(List<RoomData> rooms, PlayerData player) {
        this.rooms = rooms;
        this.player = player;
    }

    public List<RoomData> getRooms() {
        return rooms;
    }

    public void setRooms(List<RoomData> rooms) {
        this.rooms = rooms;
    }

    public PlayerData getPlayer() {
        return player;
    }

    public void setPlayer(PlayerData player) {
        this.player = player;
    }
}
