package save.savedData;

import java.util.List;

public class MapData {
    private List<String> tiles;
    private List<OverwriteData> overwrites;

    public MapData(List<String> tiles, List<OverwriteData> overwrites) {
        this.tiles = tiles;
        this.overwrites = overwrites;
    }

    public List<String> getTiles() {
        return tiles;
    }

    public void setTiles(List<String> tiles) {
        this.tiles = tiles;
    }

    public List<OverwriteData> getOverwrites() {
        return overwrites;
    }

    public void setOverwrites(List<OverwriteData> overwrites) {
        this.overwrites = overwrites;
    }
}
