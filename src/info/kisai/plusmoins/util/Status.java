package info.kisai.plusmoins.util;

/**
 * Created by spacefox on 25/08/15.
 */
public enum Status {
    MORE(Labels.MORE),
    LESS(Labels.LESS),
    FOUND(Labels.FOUND),
    ;

    private String label;

    Status(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
