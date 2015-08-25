package info.kisai.plusmoins.command.impl;

import info.kisai.plusmoins.command.ProcessAttemptCommand;
import info.kisai.plusmoins.model.bean.Attempt;
import info.kisai.plusmoins.model.bean.impl.AttemptDefaultImpl;
import info.kisai.plusmoins.model.dao.AttemptDao;
import info.kisai.plusmoins.model.dao.impl.DaoFactoryDefaultImpl;

/**
 * Created by spacefox on 25/08/15.
 */
public class ProcessAttemptCommandDefaultImpl implements ProcessAttemptCommand {

    private AttemptDao attemptDao;

    private int rawInput;
    private Attempt attempt;

    public ProcessAttemptCommandDefaultImpl() {
        attemptDao = DaoFactoryDefaultImpl.getInstance().getAttemptDao();
    }

    @Override
    public void execute() {
        attempt = new AttemptDefaultImpl(rawInput);
        attemptDao.create(attempt);
    }

    @Override
    public void setRawInput(int rawInput) {
        this.rawInput = rawInput;
    }

    @Override
    public long getAttemptId() {
        return attempt.getId();
    }
}
