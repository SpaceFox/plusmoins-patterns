package info.kisai.plusmoins.factory.impl;

import info.kisai.plusmoins.factory.InputFactory;
import info.kisai.plusmoins.factory.OutputFactory;
import info.kisai.plusmoins.view.Input;
import info.kisai.plusmoins.view.Output;
import info.kisai.plusmoins.view.impl.OutputDefaultImpl;

/**
 * Created by spacefox on 25/08/15.
 */
public class OutputDefaultFactory implements OutputFactory {

    // Singleton
    private OutputDefaultFactory() {}

    private static class OutputDefaultFactoryHolder {
        private static final OutputDefaultFactory instance = new OutputDefaultFactory();
    }

    public static OutputDefaultFactory getInstance() {
        return OutputDefaultFactoryHolder.instance;
    }

    @Override
    public Output create() {
        return new OutputDefaultImpl();
    }
}
