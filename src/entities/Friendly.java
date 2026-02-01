package entities;

import game.Colors;

public class Friendly extends Entity {
    private String message;

    public Friendly() {
        icon = Colors.GREEN+"F "+Colors.RESET;
    }

    public Friendly(String name, String message) {
        this();
        this.name = name;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
