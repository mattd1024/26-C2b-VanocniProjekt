package input.commands;

import game.Console;
import input.Command;
import map.Map;
import map.MapHelper;

/**
 * ExploreCommand vypise deskripci specifickeho MapObjectu v mape
 */
public class ExploreCommand implements Command {
    private final int x;
    private final int y;
    private final Map map;

    public ExploreCommand(String[] args, Map map) {
        this.x = Integer.parseInt(args[0]);
        this.y = Integer.parseInt(args[1]);
        this.map = map;
    }

    @Override
    public Result execute() {
        // Jsou souradnice validni
        if (!MapHelper.isValidCoordinate(x, y, map.getWidth(), map.getHeight())) {
            Console.printError("Nespravne souradnice");
            return null;
        }

        // Vyprintime deskripci map objektu na x y
        System.out.println(map.getGrid()[y][x].getDescription());
        Console.printEnter();

        return Result.CONTINUE;
    }
}

