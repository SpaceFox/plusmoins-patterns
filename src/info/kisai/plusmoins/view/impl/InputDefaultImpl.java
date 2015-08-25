package info.kisai.plusmoins.view.impl;

import info.kisai.plusmoins.view.Input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by spacefox on 25/08/15.
 */
public class InputDefaultImpl implements Input {

    private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public int readTry() {
        int value;
        String raw;
        do {
            try {
                raw = bufferedReader.readLine();
                value = Integer.valueOf(raw);
            } catch (IOException | NumberFormatException e) {
                value = Integer.MIN_VALUE;
            }
        } while (value < 0 || value > 99);
        return value;
    }
}
