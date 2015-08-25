package info.kisai.plusmoins.command.impl;

import info.kisai.plusmoins.command.InitGameCommand;
import info.kisai.plusmoins.model.bean.Guess;
import info.kisai.plusmoins.model.bean.impl.GuessDefaultImpl;
import info.kisai.plusmoins.model.dao.GuessDao;
import info.kisai.plusmoins.model.dao.impl.DaoFactoryDefaultImpl;

import java.util.Random;

/**
 * Created by spacefox on 25/08/15.
 */
public class InitGameCommandDefaultImpl implements InitGameCommand {

    private GuessDao guessDao;
    
    private Random random;
    private Guess guess;

    public InitGameCommandDefaultImpl() {
        guessDao = DaoFactoryDefaultImpl.getInstance().getGuessDao();
    }

    @Override
    public void setRandom(Random random) {
        this.random = random;
    }

    @Override
    public Guess getGuess() {
        return guess;
    }

    @Override
    public void execute() {
        guess = new GuessDefaultImpl(random);
        guessDao.create(guess);
    }
}
