package input.commands;

import entities.Player;
import game.Colors;
import game.Console;
import input.Command;
import map.Map;
import map.MapHelper;
import worldObjects.EscapeRocket;

/**
 * Pokud je pouzit u unikove rakety tak uspesne ohlasi vitezstvi a ukonci hru
 */
public class EscapeCommand implements Command {
    private final int x;
    private final int y;
    private final Map map;
    private final Player player;

    public EscapeCommand(String[] args, Map map, Player player) {
        this.x = Integer.parseInt(args[0]);
        this.y = Integer.parseInt(args[1]);
        this.map = map;
        this.player = player;
    }

    @Override
    public Result execute() {
        // Jsou souradnice validni
        if (!MapHelper.isValidCoordinate(x, y, map.getWidth(), map.getHeight())) {
            Console.printError("Nespravne souradnice");
            return null;
        }

        // Zjistime vzdálenost mezi hracem a raketou
        int dx = Math.abs(player.getX() - x);
        int dy = Math.abs(player.getY() - y);

        // Pokud neni dost blizko
        if (dx > 1 || dy > 1) {
            Console.printError("Jsi moc daleko od rakety");
            return null;
        }

        // Vezmeme objekt a zjistime jestli existuje
        EscapeRocket rocket = (EscapeRocket) map.getMapObject(x, y);
        if (rocket == null) {
            Console.printError("Zde neni raketa");
            return null;
        }

        // Ma hrac dostatek morkitu?
        if (player.getInventory().getMorkiteAmount() >= 2) {
            Console.printColorMessage("Dosahl si rakety a mas dostatecny pocet morkitu! Vyhral si", Colors.GREEN);
            Console.printEnter();
            return Result.END_GAME;
        } else {
            Console.printColorMessage("Nemas dostatek morkitu! Musis mit 200, ale mas: " +
                    player.getInventory().getMorkiteAmount(), Colors.RED);
            Console.printEnter();
            return Result.CONTINUE;
        }
    }
}
