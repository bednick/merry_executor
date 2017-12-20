
import bricks.Command;
import executor.IExecutor;
import executor.ISorter;
import parser.IParser;
import parser.Parser;

import java.io.IOException;
import java.util.Collection;

public class MerryExecutor {
    public static void main(String[] args) {
        IParser parser = new Parser();
        ISorter sorter = null;
        IExecutor executor = null;
        try {
            parser.load(args[0]);
            Collection<Command> commands = parser.getData();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
