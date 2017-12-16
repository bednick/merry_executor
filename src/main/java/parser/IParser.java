package parser;

import bricks.Command;

import java.util.Collection;

public interface IParser {

    void load(String fileName);

    Collection<Command> getData();
}
