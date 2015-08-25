package info.kisai.plusmoins.factory.impl;

import info.kisai.plusmoins.command.InitGameCommand;
import info.kisai.plusmoins.command.impl.InitGameCommandDefaultImpl;
import info.kisai.plusmoins.factory.InitGameCommandFactory;

/**
 * Created by spacefox on 25/08/15.
 */
public class InitGameCommandDefaultFactory implements InitGameCommandFactory {

    // Singleton
    private InitGameCommandDefaultFactory() {}

    private static class InitGameCommandDefaultFactoryHolder {
        private static final InitGameCommandDefaultFactory instance = new InitGameCommandDefaultFactory();
    }

    public static InitGameCommandDefaultFactory getInstance() {
        return InitGameCommandDefaultFactoryHolder.instance;
    }


    @Override
    public InitGameCommand create() {
        return new InitGameCommandDefaultImpl();
    }
}
