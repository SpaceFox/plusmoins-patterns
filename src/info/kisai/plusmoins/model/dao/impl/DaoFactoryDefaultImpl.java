package info.kisai.plusmoins.model.dao.impl;

import info.kisai.plusmoins.model.dao.AttemptDao;
import info.kisai.plusmoins.model.dao.DaoFactory;
import info.kisai.plusmoins.model.dao.GuessDao;

/**
 * Created by spacefox on 25/08/15.
 */
public class DaoFactoryDefaultImpl implements DaoFactory {

    // Singleton
    private DaoFactoryDefaultImpl() {}

    private static class DaoFactoryDefaultImplHolder {
        private static final DaoFactoryDefaultImpl instance = new DaoFactoryDefaultImpl();
    }

    public static DaoFactoryDefaultImpl getInstance() {
        return DaoFactoryDefaultImplHolder.instance;
    }

    @Override
    public GuessDao getGuessDao() {
        return new GuessDaoDefaultImpl(this);
    }

    @Override
    public AttemptDao getAttemptDao() {
        return new AttemptDaoDefaultImpl(this);
    }

    @Override
    public String getStorePrefix() {
        return "plusmoins_";
    }
}
