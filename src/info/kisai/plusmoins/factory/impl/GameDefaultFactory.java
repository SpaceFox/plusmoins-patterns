package info.kisai.plusmoins.factory.impl;

import info.kisai.plusmoins.controller.Game;
import info.kisai.plusmoins.controller.impl.GameDefaultImpl;
import info.kisai.plusmoins.factory.GameFactory;

/**
 * Created by spacefox on 25/08/15.
 */
public class GameDefaultFactory implements GameFactory {

    // Singleton
    private GameDefaultFactory() {}

    private static class GameDefaultFactoryHolder {
        private static final GameDefaultFactory instance = new GameDefaultFactory();
    }

    public static GameDefaultFactory getInstance() {
        return GameDefaultFactoryHolder.instance;
    }

    @Override
    public Game create() {
        return new GameDefaultImpl();
    }
}
