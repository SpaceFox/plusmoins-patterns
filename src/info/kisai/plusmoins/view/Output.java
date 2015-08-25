package info.kisai.plusmoins.view;

/**
 * Created by spacefox on 25/08/15.
 */
public interface Output {
    void print(String key);
    void print(String key, Object... arguments);
}
