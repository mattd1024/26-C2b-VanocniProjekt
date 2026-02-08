package input.commands;

import game.Game;
import input.Command;

/**
 * EndCommand ukoncuje hru
 */
public class EndCommand implements Command {


    @Override
    public void execute() {
        System.out.println("Konec hry!");
    }
}
