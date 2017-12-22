
import bricks.Command;
import drawer.DrawerGraph;
import drawer.IDrawer;
import executor.IExecutor;
import executor.ISorter;
import executor.SorterLinear;
import parser.IParser;
import parser.Parser;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class MerryExecutor {
    public static void main(String[] args) {
        IParser parser = new Parser();
        ISorter sorter = new SorterLinear();
        IExecutor executor = null;
        IDrawer drawer = new DrawerGraph();
        String[] nameOut = Arrays.copyOfRange(args, 1, args.length);
        try {
            parser.load(args[0]);
            Collection<Command> commands = parser.getData();
            List<String> sort = sorter.sort(commands, new ArrayList<>(Arrays.asList(nameOut)), getEnvironment());
            //executor.exec(sort);
            drawer.draw(commands);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Set<String> getEnvironment() {
        File myFolder = new File(".");
        File[] files = myFolder.listFiles();
        Set<String> environment = new HashSet<>();
        for (File file: files) {
            if (file.isFile()) {
                environment.add(file.getName());
            }
        }
        return environment;
    }
}
