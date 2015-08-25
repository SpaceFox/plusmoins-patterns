package info.kisai.plusmoins.model.dao.impl;

import info.kisai.plusmoins.model.bean.Attempt;
import info.kisai.plusmoins.model.dao.AttemptDao;
import info.kisai.plusmoins.model.dao.DaoFactory;
import info.kisai.plusmoins.model.dao.FileDaoImplementation;
import info.kisai.plusmoins.model.dao.exception.DAOException;

import java.io.*;

/**
 * Created by spacefox on 25/08/15.
 */
public class AttemptDaoDefaultImpl extends FileDaoImplementation implements AttemptDao {

    private DaoFactory daoFactory;

    public AttemptDaoDefaultImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public Attempt find(long id) throws DAOException {
        Attempt attempt;
        File file = openFile(daoFactory.getStorePrefix(), id);
        try (
                InputStream inputStream = new FileInputStream(file);
                InputStream buffer = new BufferedInputStream(inputStream);
                ObjectInput input = new ObjectInputStream(buffer);
        ) {
            attempt = (Attempt) input.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new DAOException(e);
        }
        return attempt;
    }

    @Override
    public void create(Attempt attempt) throws DAOException {
        File file = openFile(daoFactory.getStorePrefix(), attempt);
        try (
                OutputStream outputStream = new FileOutputStream(file);
                OutputStream buffer = new BufferedOutputStream(outputStream);
                ObjectOutput output = new ObjectOutputStream(buffer);
        ) {
            output.writeObject(attempt);
        } catch (IOException e) {
            throw new DAOException(e);
        }
    }

    @Override
    protected String getExtension() {
        return "attempt";
    }
}
