package info.kisai.plusmoins.model.bean.impl;

import info.kisai.plusmoins.model.bean.Attempt;
import info.kisai.plusmoins.model.bean.Guess;

import java.util.Random;

/**
 * Created by spacefox on 25/08/15.
 */
public class AttemptDefaultImpl extends BeanDefaultImpl implements Attempt {

    private int value;

    public AttemptDefaultImpl(int value) {
        super();
        this.value = value;
    }

    @Override
    public int getValue() {
        return value;
    }
}
