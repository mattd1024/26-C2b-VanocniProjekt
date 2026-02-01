package input.commands;

import entities.Player;
import input.Command;
import map.Map;

public class MoveCommand implements Command {
    private int crrX; // Current x position
    private int crrY; // Current y position
    private String direction; // W,A,S,D
    private int steps; // 1-3
    private Map map;

    @Override
    public void execute() {
        int newX = crrX;
        int newY = crrY;
        switch(direction) {
            case "W":

                break;
            case "A":

                break;
                case "S":

                    break;
            case "D":

                break;
        }
    }
}
