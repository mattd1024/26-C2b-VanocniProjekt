package game;

import com.google.gson.Gson;
import save.SaveData;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * Trida SaveManager obsluhuje ukladani herniho sveta
 */
public class SaveManager {
    private Gson gson;

    public SaveManager() {
        this.gson = new Gson();
    }

    /**
     * Nacte .json ulozny soubor a vraci objekt typu SaveData
     * @param filePath String cesta k souboru
     * @return SaveData saveData
     */
    public SaveData loadGame(String filePath) {
        SaveData save = null;

        try(Reader reader = new FileReader(filePath)) {
            save = gson.fromJson(reader, SaveData.class);
        } catch (IOException e) {
            throw new RuntimeException("Nenalezen .json soubor, cesta: " + filePath);
        }
        return save;
    }
}
