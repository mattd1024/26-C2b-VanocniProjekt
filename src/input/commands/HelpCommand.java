package input.commands;

import game.Console;
import input.Command;

/**
 * HelpCommand vypise vsechny mozne komandy
 */
public class HelpCommand implements Command {

    @Override
    public Result execute() {
        System.out.println("Dostupne komandy:");
        System.out.println("    attack x y               ==> Zautocis na nepritele na x y");
        System.out.println("    collect x y              ==> Sesbiras resupply na x y");
        System.out.println("    end                      ==> Ukoncis hru");
        System.out.println("    explore x y              ==> Vypise informace o predmetu na x y");
        System.out.println("    help                     ==> Vypiste tuto napovedu s komandama");
        System.out.println("    inventory                ==> Vypise vsechno co mas inventary");
        System.out.println("    mine x y                 ==> Vytezis rudu na x y, musis byt blizko");
        System.out.println("    w | a | s | d            ==> Pohyb po mape, az 3x krat opakovatelne v jednom prikazu");
        System.out.println("    resupply x y             ==> Zavolas si zasobovaci raketu na x y, stoji 80 nitry");
        System.out.println("    room                     ==> Vypise informaci o mistnosti, ve ktere jsi");
        System.out.println("    setweapon <jmeno zbrane> ==> Nastavi tvoji primarni zbran aby si mohl utocit");
        System.out.println("    talk x y                 ==> Promluvis s postavou na x y");
        Console.printEnter();

        return Result.CONTINUE;
    }
}
