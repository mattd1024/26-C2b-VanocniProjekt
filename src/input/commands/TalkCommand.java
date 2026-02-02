package input.commands;

import entities.Entity;
import entities.Friendly;
import entities.Player;
import entities.ShopBot;
import game.Console;
import input.Command;
import map.Map;

public class TalkCommand implements Command {
    private final int x;
    private final int y;
    private final Map map;
    private final Player player;

    public TalkCommand(int x, int y, Map map, Player player) {
        this.x = x;
        this.y = y;
        this.map = map;
        this.player = player;
    }

    @Override
    public void execute() {
        // Jsou souradnice validni
        if (y < 0 || y >= map.getMap().length || x < 0 || x >= map.getMap()[0].length) {
            System.out.println("Nespravne koordinaty");
            return;
        }

        // Zjistime vzdálenost mezi hracem a entitou
        int dx = Math.abs(player.getX() - x);
        int dy = Math.abs(player.getY() - y);

        // Pokud neni dost blizko
        if (dx > 1 || dy > 1) {
            System.out.println("Jsi moc daleko od entity");
            Console.printEnter();
            return;
        }

        // Vezmeme entitu a zjistime jestli existuje
        Entity entity = (Entity) map.getMapObject(y, x);
        if (entity == null) {
            System.out.println("Zde neni entita");
            Console.printEnter();
            return;
        }

        // Pro Friendly
        if (entity instanceof Friendly) {
            ((Friendly) entity).talk();
        } else {
            // Pro obchodniho bota
            if (entity instanceof ShopBot) {
                ((ShopBot) entity).talk(player);
            } else {
                System.out.println("S touto entitou nelze mluvit");
                Console.printEnter();
            }
        }
    }
}
