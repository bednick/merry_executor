
import bricks.Command;
import drawer.DrawerGraph;
import drawer.IDrawer;
import executor.*;
import parser.IParser;
import parser.Parser;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class MerryExecutor {
    public static void main(String[] args) {
        IParser parser = new Parser();
        ISorter sorter = new SorterLinear();
        IExecutor executor = new Executor();
        IDrawer drawer = new DrawerGraph();
        //String[] nameOut = Arrays.copyOfRange(args, 1, args.length);
        String[] nameOut = {"step_16", "step_14"};
        try {
            parser.load("examples/example_start.cm");
            Collection<Command> commands = parser.getData();
            List<String> sort = sorter.sort(commands, new ArrayList<>(Arrays.asList(nameOut)), getEnvironment());
            drawer.draw(commands);
            executor.exec(sort);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (FailProcessingException e) {
            e.printStackTrace();
        }
    }

    private static Set<String> getEnvironment() {
        File myFolder = new File(".");
        File[] files = myFolder.listFiles();
        Set<String> environment = new HashSet<>();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    environment.add(file.getName());
                }
            }
        }
        return environment;
    }
}
