package info.kisai.plusmoins.command;

import info.kisai.plusmoins.util.Status;

/**
 * Created by spacefox on 25/08/15.
 */
public interface MainLoopCommand extends Command {
    boolean isFinished();

    void setGuessId(long guessId);

    int getAttemptCount();


    void setAttemptId(long attemptId);

    Status getStatus();
}
