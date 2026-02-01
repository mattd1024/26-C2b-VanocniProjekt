package save.savedData;



import save.overwriteType;

import java.util.Map;

public class OverwriteData {
    private overwriteType type;
    private PositionData position;
    private Map<String, Object> state;

    public OverwriteData(overwriteType type, PositionData position, Map<String, Object> state) {
        this.type = type;
        this.position = position;
        this.state = state;
    }


    public overwriteType getType() {
        return type;
    }

    public void setType(overwriteType type) {
        this.type = type;
    }

    public PositionData getPosition() {
        return position;
    }

    public void setPosition(PositionData position) {
        this.position = position;
    }

    public Map<String, Object> getState() {
        return state;
    }

    public void setState(Map<String, Object> state) {
        this.state = state;
    }
}
