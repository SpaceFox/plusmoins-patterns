package info.kisai.plusmoins.model.dao;

import info.kisai.plusmoins.model.bean.Bean;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Created by spacefox on 25/08/15.
 */
public abstract class FileDaoImplementation {

    private static final Path basePath;
    static {
        Path tmp;
        try {
            tmp = Files.createTempDirectory("plusmoins");
        } catch (IOException e) {
            tmp = null;
        }
        basePath = tmp;
    }

    protected abstract String getExtension();

    protected File openFile(String prefix, Bean bean) {
        return openFile(prefix, bean.getId());
    }

    protected File openFile(String prefix, long id) {
        return new File(basePath + "/" + prefix + Long.toHexString(id) + "." + getExtension());
    }
}
