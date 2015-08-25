package info.kisai.plusmoins.model.dao;

/**
 * Created by spacefox on 25/08/15.
 */
public interface DaoFactory {
    GuessDao getGuessDao();

    AttemptDao getAttemptDao();

    String getStorePrefix();
}
