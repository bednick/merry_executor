
import bricks.Command;
import drawer.DrawerGraph;
import drawer.IDrawer;
import executor.IExecutor;
import executor.ISorter;
import parser.IParser;
import parser.Parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class MerryExecutor {
    public static void main(String[] args) {
        IParser parser = new Parser();
        ISorter sorter = null;
        IExecutor executor = null;
        IDrawer drawer = new DrawerGraph();
        String[] nameOut = Arrays.copyOfRange(args, 1, args.length);
        try {
            parser.load(args[0]);
            Collection<Command> commands = parser.getData();
            List<Command> sort = sorter.sort(commands, new ArrayList<>(Arrays.asList(nameOut)));
            executor.exec(sort);
            drawer.draw(sort);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
