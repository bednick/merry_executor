package parser;

import bricks.Command;

import java.io.IOException;
import java.util.Collection;

public interface IParser {

    void load(String fileName) throws IOException;

    Collection<Command> getData();
}
