package input.commands;

import game.Console;
import input.Command;
import map.Map;

public class ExploreCommand implements Command {
    private final int x;
    private final int y;
    private final Map map;

    public ExploreCommand(int x, int y, Map map) {
        this.x = x;
        this.y = y;
        this.map = map;
    }

    @Override
    public void execute() {
        // Jsou souradnice validni
        if (y < 0 || y >= map.getMap().length || x < 0 || x >= map.getMap()[0].length) {
            System.out.println("Nespravne souradnice");
            Console.printEnter();
            return;
        }

        // Vyprintime deskripci map objektu na x y
        System.out.println(map.getMap()[y][x].getDescription());
        Console.printEnter();

    }
}

