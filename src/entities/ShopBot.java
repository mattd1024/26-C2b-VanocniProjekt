package entities;

import game.Colors;
import game.Console;
import inventory.items.Item;
import inventory.items.Weapon;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Trida ShopBot je obchod o bot
 * Hrac s nim muze obchodovat za zlato
 */
public class ShopBot extends Entity{
    ArrayList<Weapon> shop = new ArrayList<>();

    public ShopBot() {
        description = "Obchodobot: kdyz s nim promluvis tak od neho muzes nakoupit zbrane";
        icon = Colors.PURPLE+"S "+ Colors.RESET;
        // Pridat defaultne dostupne zbrane
        shop.add(new Weapon("Pistole", 3, 20, 1, 20));
        shop.add(new Weapon("Puska", 6, 50, 5, 40));
        shop.add(new Weapon("Sniperka", 20, 100, 10, 80));
    }

    /**
     * Promluveni s hracem a obchod botem
     * @param player Player player
     */
    public void talk(Player player) {
        System.out.println("Vitej v mem obchode! Zadej jmeno produktu, ktery chces zakoupit:");

        // Printime zbrane ktere bot ma
        for (Weapon weapon : shop) {
            System.out.println(weapon);
        }

        // Ziskame input od hrace
        String option = Console.getInputFromUser();

        // Zkusime koupit predmet
        for (int i = 0; i < shop.size(); i++) {
            Weapon weapon = shop.get(i);
            if (option.equalsIgnoreCase(weapon.getName())) {
                if (player.getInventory().getGoldAmount() >= weapon.getCost()) {
                    player.getInventory().addWeapon(weapon);
                    player.getInventory().setGoldAmount(player.getInventory().getGoldAmount() - weapon.getCost());
                    shop.remove(i);
                    System.out.println("Dekuji za tve obchodovani");
                    Console.printEnter();
                } else {
                    System.out.println("Na tohle nemas dostatek penez!");
                    Console.printEnter();
                }
                return;
            }
        }
        System.out.println("Tohle tady nemam");
        Console.printEnter();
    }
}
