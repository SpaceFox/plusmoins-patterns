package info.kisai.plusmoins.factory.impl;

import info.kisai.plusmoins.command.ProcessAttemptCommand;
import info.kisai.plusmoins.command.impl.ProcessAttemptCommandDefaultImpl;
import info.kisai.plusmoins.factory.ProcessAttemptCommandFactory;

/**
 * Created by spacefox on 25/08/15.
 */
public class ProcessAttemptCommandDefaultFactory implements ProcessAttemptCommandFactory {

    // Singleton
    private ProcessAttemptCommandDefaultFactory() {}

    private static class ProcessTryCommandDefaultFactoryHolder {
        private static final ProcessAttemptCommandDefaultFactory instance = new ProcessAttemptCommandDefaultFactory();
    }

    public static ProcessAttemptCommandDefaultFactory getInstance() {
        return ProcessTryCommandDefaultFactoryHolder.instance;
    }


    @Override
    public ProcessAttemptCommand create() {
        return new ProcessAttemptCommandDefaultImpl();
    }
}
