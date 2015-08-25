package info.kisai.plusmoins.factory.impl;

import info.kisai.plusmoins.command.MainLoopCommand;
import info.kisai.plusmoins.command.impl.MainLoopCommandDefaultImpl;
import info.kisai.plusmoins.factory.MainLoopCommandFactory;

/**
 * Created by spacefox on 25/08/15.
 */
public class MainLoopCommandDefaultFactory implements MainLoopCommandFactory {

    // Singleton
    private MainLoopCommandDefaultFactory() {}

    private static class MainLoopCommandDefaultFactoryHolder {
        private static final MainLoopCommandDefaultFactory instance = new MainLoopCommandDefaultFactory();
    }

    public static MainLoopCommandDefaultFactory getInstance() {
        return MainLoopCommandDefaultFactoryHolder.instance;
    }


    @Override
    public MainLoopCommand create() {
        return new MainLoopCommandDefaultImpl();
    }
}
