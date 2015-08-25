package info.kisai.plusmoins.factory.impl;

import info.kisai.plusmoins.controller.Game;
import info.kisai.plusmoins.controller.impl.GameDefaultImpl;
import info.kisai.plusmoins.factory.GameFactory;
import info.kisai.plusmoins.factory.InputFactory;
import info.kisai.plusmoins.view.Input;
import info.kisai.plusmoins.view.impl.InputDefaultImpl;

/**
 * Created by spacefox on 25/08/15.
 */
public class InputDefaultFactory implements InputFactory {

    // Singleton
    private InputDefaultFactory() {}

    private static class InputDefaultFactoryHolder {
        private static final InputDefaultFactory instance = new InputDefaultFactory();
    }

    public static InputDefaultFactory getInstance() {
        return InputDefaultFactoryHolder.instance;
    }

    @Override
    public Input create() {
        return new InputDefaultImpl();
    }
}
