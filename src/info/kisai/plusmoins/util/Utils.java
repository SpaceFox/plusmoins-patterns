package info.kisai.plusmoins.util;

import info.kisai.plusmoins.model.bean.Attempt;
import info.kisai.plusmoins.model.bean.Guess;

/**
 * Created by spacefox on 25/08/15.
 */
public class Utils {

    private static long nextId = System.currentTimeMillis();

    private Utils() {
        // Classe non instanciable
    }

    public static synchronized long generateUniqueId() {
        nextId = nextId + 1;
        return nextId;
    }

    public static Status compare(Guess guess, Attempt attempt) {
        Status status;
        if (guess.getValue() > attempt.getValue()) {
            status = Status.MORE;
        } else if (guess.getValue() < attempt.getValue()) {
            status = Status.LESS;
        } else {
            status = Status.FOUND;
        }
        return status;
    }
}
