package info.kisai.plusmoins.command;

import info.kisai.plusmoins.model.bean.Guess;

import java.util.Random;

/**
 * Created by spacefox on 25/08/15.
 */
public interface InitGameCommand extends Command {
    void setRandom(Random random);

    Guess getGuess();
}
