package entities;

import game.Colors;
import game.Console;

public class Friendly extends Entity {
    private String message;

    public Friendly() {
        description = "Kamarad trpaslik: muzes si s nim promluvit pro uzitecne rady";
        icon = Colors.GREEN+"F "+Colors.RESET;
    }

    public Friendly(String name, String message) {
        this();
        this.name = name;
        this.message = message;
    }

    public void talk() {
        System.out.println(name);
        System.out.println("    " + message);
        Console.printEnter();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
