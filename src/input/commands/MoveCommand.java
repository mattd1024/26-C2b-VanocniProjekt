package input.commands;

import entities.Player;
import game.Console;
import input.Command;
import map.Map;
import map.MapHelper;
import worldObjects.Floor;

import java.util.List;

/**
 * MoveCommand zpracuje pohyb hrace v mape
 */
public class MoveCommand implements Command {
    private final Player player;
    private final List<Character> moves;
    private final Map map;

    public MoveCommand(Player player, List<Character> moves, Map map) {
        this.player = player;
        this.moves = moves;
        this.map = map;
    }

    @Override
    public Result execute() {
        int currentX = player.getX();
        int currentY = player.getY();

        for (char c : moves) {
            int newX = currentX;
            int newY = currentY;

            switch (c) {
                case 'w':
                    newY--;
                    break;
                case 'a':
                    newX--;
                    break;
                case 's':
                    newY++;
                    break;
                case 'd':
                    newX++;
                    break;
            }

            // Jsou souradnice validni
            if (!MapHelper.isValidCoordinate(newX, newY, map.getWidth(), map.getHeight())) {
                Console.printError("Nespravne souradnice");
                return null;
            }

            if (map.getGrid()[newY][newX].isWalkable()) {
                map.addMapObject(newX, newY, player);
                map.addMapObject(currentX, currentY, new Floor());

                player.setX(newX);
                player.setY(newY);

                currentX = newX;
                currentY = newY;
            } else {
                System.out.println("Sem nemuzes jit");
                break;
            }
        }
        return Result.END_TURN;
    }
}

