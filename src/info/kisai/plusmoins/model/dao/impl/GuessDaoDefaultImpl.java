package info.kisai.plusmoins.model.dao.impl;

import info.kisai.plusmoins.model.bean.Guess;
import info.kisai.plusmoins.model.dao.DaoFactory;
import info.kisai.plusmoins.model.dao.FileDaoImplementation;
import info.kisai.plusmoins.model.dao.GuessDao;
import info.kisai.plusmoins.model.dao.exception.DAOException;

import java.io.*;

/**
 * Created by spacefox on 25/08/15.
 */
public class GuessDaoDefaultImpl extends FileDaoImplementation implements GuessDao {

    private DaoFactory daoFactory;

    public GuessDaoDefaultImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public Guess find(long id) throws DAOException {
        Guess guess;
        File file = openFile(daoFactory.getStorePrefix(), id);
        try (
                InputStream inputStream = new FileInputStream(file);
                InputStream buffer = new BufferedInputStream(inputStream);
                ObjectInput input = new ObjectInputStream(buffer);
        ) {
            guess = (Guess) input.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new DAOException(e);
        }
        return guess;
    }

    @Override
    public void create(Guess guess) throws DAOException {
        File file = openFile(daoFactory.getStorePrefix(), guess);
        try (
                OutputStream outputStream = new FileOutputStream(file);
                OutputStream buffer = new BufferedOutputStream(outputStream);
                ObjectOutput output = new ObjectOutputStream(buffer);
        ) {
            output.writeObject(guess);
        } catch (IOException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public String getExtension() {
        return "guess";
    }
}
