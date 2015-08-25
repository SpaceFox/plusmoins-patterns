package info.kisai.plusmoins.model.bean.impl;

import info.kisai.plusmoins.model.bean.Bean;
import info.kisai.plusmoins.util.Utils;

/**
 * Created by spacefox on 25/08/15.
 */
public abstract class BeanDefaultImpl implements Bean {

    private long id;

    protected BeanDefaultImpl() {
        id = Utils.generateUniqueId();
    }

    @Override
    public long getId() {
        return id;
    }
}
