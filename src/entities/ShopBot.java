package entities;

import game.Colors;
import inventory.items.Item;

import java.util.HashMap;

public class ShopBot extends Entity{
    HashMap<Item, Integer> shop = new HashMap<>(); //TODO finalize shopping

    public ShopBot() {
        icon = Colors.PURPLE+"S "+ Colors.RESET;
    }

    public void talk() {}

}
