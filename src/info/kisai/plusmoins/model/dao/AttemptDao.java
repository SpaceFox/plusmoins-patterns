package info.kisai.plusmoins.model.dao;

import info.kisai.plusmoins.model.bean.Attempt;
import info.kisai.plusmoins.model.dao.exception.DAOException;

/**
 * Created by spacefox on 25/08/15.
 */
public interface AttemptDao {

    Attempt find(long id) throws DAOException;
    void create(Attempt attempt) throws DAOException;

}
