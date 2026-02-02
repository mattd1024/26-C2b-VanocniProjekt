package input.commands;

import game.Game;
import input.Command;

public class EndCommand implements Command {


    @Override
    public void execute() {
        System.out.println("Ending game!");
    }
}
