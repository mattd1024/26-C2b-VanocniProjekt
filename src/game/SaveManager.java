package game;

import com.google.gson.Gson;
import save.SaveData;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class SaveManager {
    private Gson gson;

    public SaveManager() {
        this.gson = new Gson();
    }

    /**
     * Loads a .json savefile and returns a SaveData object
     * @param filePath path to file
     * @return SaveData object
     */
    public SaveData loadGame(String filePath) {
        SaveData save = null;

        try(Reader reader = new FileReader(filePath)) {
            save = gson.fromJson(reader, SaveData.class);
        } catch(IOException e) {
            e.printStackTrace();
        }
        return save;
    }

    public void saveGame(String path) {

    }
}
