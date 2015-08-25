package info.kisai.plusmoins.controller.impl;

import info.kisai.plusmoins.command.InitGameCommand;
import info.kisai.plusmoins.command.MainLoopCommand;
import info.kisai.plusmoins.command.ProcessAttemptCommand;
import info.kisai.plusmoins.controller.Game;
import info.kisai.plusmoins.factory.impl.*;
import info.kisai.plusmoins.util.Labels;
import info.kisai.plusmoins.view.Input;
import info.kisai.plusmoins.view.Output;

import java.util.Random;

/**
 * Created by spacefox on 25/08/15.
 */
public class GameDefaultImpl implements Game {

    private Input input;
    private Output output;

    private long guessId;

    @Override
    public void init() {

        // Init I/O
        input = InputDefaultFactory.getInstance().create();
        output = OutputDefaultFactory.getInstance().create();

        // Init the Guess
        InitGameCommand initGameCommand = InitGameCommandDefaultFactory.getInstance().create();

        initGameCommand.setRandom(new Random());

        initGameCommand.execute();

        guessId = initGameCommand.getGuess().getId();
    }

    @Override
    public void start() {
        output.print(Labels.WELCOME);
        output.print(Labels.RULES);

        MainLoopCommand mainLoopCommand = MainLoopCommandDefaultFactory.getInstance().create();
        mainLoopCommand.setGuessId(guessId);
        do {
            output.print(Labels.TURN, mainLoopCommand.getAttemptCount());
            output.print(Labels.ASK_NUMBER);
            int rawInput = input.readTry();

            long attemptId = processAttempt(rawInput);

            mainLoopCommand.setAttemptId(attemptId);
            mainLoopCommand.execute();

            output.print(mainLoopCommand.getStatus().getLabel(), rawInput);
        } while (!mainLoopCommand.isFinished());

        output.print(Labels.VICTORY, mainLoopCommand.getAttemptCount());
    }

    private long processAttempt(int rawInput) {
        ProcessAttemptCommand processAttemptCommand = ProcessAttemptCommandDefaultFactory.getInstance().create();
        processAttemptCommand.setRawInput(rawInput);

        processAttemptCommand.execute();

        return processAttemptCommand.getAttemptId();
    }
}
