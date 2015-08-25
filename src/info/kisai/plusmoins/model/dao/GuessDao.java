package info.kisai.plusmoins.model.dao;

import info.kisai.plusmoins.model.bean.Guess;
import info.kisai.plusmoins.model.dao.exception.DAOException;

/**
 * Created by spacefox on 25/08/15.
 */
public interface GuessDao {

    Guess find(long id) throws DAOException;
    void create(Guess guess) throws DAOException;

}
