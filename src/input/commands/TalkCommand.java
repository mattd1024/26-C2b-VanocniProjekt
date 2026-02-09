package input.commands;

import entities.Entity;
import entities.Friendly;
import entities.Player;
import entities.ShopBot;
import game.Console;
import input.Command;
import map.Map;
import map.MapHelper;

/**
 * TalkCommand obsluhuje komunikaci mezi hracem a entitou (pouze Friendly nebo ShopBot)
 */
public class TalkCommand implements Command {
    private final int x;
    private final int y;
    private final Map map;
    private final Player player;

    public TalkCommand(String[] args, Map map, Player player) {
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

        // Zjistime vzdálenost mezi hracem a entitou
        int dx = Math.abs(player.getX() - x);
        int dy = Math.abs(player.getY() - y);

        // Pokud neni dost blizko
        if (dx > 1 || dy > 1) {
            Console.printError("Jsi moc daleko od entity");
            return null;
        }

        // Vezmeme entitu a zjistime jestli existuje
        Entity entity = (Entity) map.getMapObject(x, y);
        if (entity == null) {
            Console.printError("Zde neni entita");
            return null;
        }

        // Pro Friendly
        if (entity instanceof Friendly) {
            ((Friendly) entity).talk();
        } else {
            // Pro obchodniho bota
            if (entity instanceof ShopBot) {
                ((ShopBot) entity).talk(player);
            } else {
                Console.printError("S timhle nemuzes mluvit");
            }
        }

        return Result.CONTINUE;
    }
}
