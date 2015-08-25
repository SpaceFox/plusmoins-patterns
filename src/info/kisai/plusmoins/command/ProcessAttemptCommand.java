package info.kisai.plusmoins.command;

/**
 * Created by spacefox on 25/08/15.
 */
public interface ProcessAttemptCommand extends Command {
    void setRawInput(int rawInput);

    long getAttemptId();
}
