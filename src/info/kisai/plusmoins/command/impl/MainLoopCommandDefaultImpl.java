package info.kisai.plusmoins.command.impl;

import info.kisai.plusmoins.command.MainLoopCommand;
import info.kisai.plusmoins.model.bean.Attempt;
import info.kisai.plusmoins.model.bean.Guess;
import info.kisai.plusmoins.model.dao.AttemptDao;
import info.kisai.plusmoins.model.dao.GuessDao;
import info.kisai.plusmoins.model.dao.impl.DaoFactoryDefaultImpl;
import info.kisai.plusmoins.util.Status;
import info.kisai.plusmoins.util.Utils;

/**
 * Created by spacefox on 25/08/15.
 */
public class MainLoopCommandDefaultImpl implements MainLoopCommand {

    private GuessDao guessDao;
    private AttemptDao attemptDao;

    private long guessId;
    private long attemptId;

    private int attemptCount;

    private Status status;

    public MainLoopCommandDefaultImpl() {
        guessDao = DaoFactoryDefaultImpl.getInstance().getGuessDao();
        attemptDao = DaoFactoryDefaultImpl.getInstance().getAttemptDao();

        attemptCount = 1;
    }

    @Override
    public boolean isFinished() {
        return status == Status.FOUND;
    }

    @Override
    public void setGuessId(long guessId) {
        this.guessId = guessId;
    }

    @Override
    public int getAttemptCount() {
        return attemptCount;
    }

    @Override
    public void setAttemptId(long attemptId) {
        this.attemptId = attemptId;
    }

    @Override
    public Status getStatus() {
        return status;
    }

    @Override
    public void execute() {
        Guess guess = guessDao.find(guessId);
        Attempt attempt = attemptDao.find(attemptId);

        status = Utils.compare(guess, attempt);
        if (!isFinished()) {
            attemptCount = attemptCount + 1;
        }
    }
}
