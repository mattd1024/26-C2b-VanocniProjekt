package input.commands;

import entities.Player;
import input.Command;
import map.Map;
import worldObjects.Floor;
import worldObjects.OreNode;

import java.util.List;

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
    public void execute() {
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

            // ZJistime jestli jde pohyb ven z mapy
            if (newY < 0 || newY >= map.getMap().length || newX < 0 || newX >= map.getMap()[0].length) {
                break;
            }

            if (map.getMap()[newY][newX].isWalkable()) {
                map.addMapObject(newY, newX, player);
                map.addMapObject(currentY, currentX, new Floor());

                player.setX(newX);
                player.setY(newY);

                currentX = newX;
                currentY = newY;
            } else {
                System.out.println("Sem nemuzes jit");
                break;
            }
        }
    }
}

