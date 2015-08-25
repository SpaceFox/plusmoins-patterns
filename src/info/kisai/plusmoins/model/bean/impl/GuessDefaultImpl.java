package info.kisai.plusmoins.model.bean.impl;

import info.kisai.plusmoins.model.bean.Guess;

import java.util.Random;

/**
 * Created by spacefox on 25/08/15.
 */
public class GuessDefaultImpl extends BeanDefaultImpl implements Guess {

    private int value;

    public GuessDefaultImpl(Random random) {
        super();
        value = random.nextInt(100);
    }

    @Override
    public int getValue() {
        return value;
    }
}
