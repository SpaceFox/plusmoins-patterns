package info.kisai.plusmoins.view.impl;

import info.kisai.plusmoins.view.Output;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by spacefox on 25/08/15.
 */
public class OutputDefaultImpl implements Output {

    private ResourceBundle messages;

    public OutputDefaultImpl() {
        messages = ResourceBundle.getBundle("LabelsBundle", Locale.getDefault());
    }

    @Override
    public void print(String key) {
        System.out.println(messages.getString(key));
    }

    @Override
    public void print(String key, Object... arguments) {
        MessageFormat formatter = new MessageFormat("", Locale.getDefault());
        formatter.applyPattern(messages.getString(key));
        System.out.println(formatter.format(arguments));
    }
}
