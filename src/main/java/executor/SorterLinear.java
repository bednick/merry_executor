package executor;

import bricks.Command;
import bricks.Pair;
import bricks.graph.OrientedGraph;
import bricks.graph.Vertex;

import java.util.*;

public class SorterLinear implements ISorter{

    @Override
    public List<String> sort(Collection<Command> data, List<String> outState, Set<String> startStates) {
        Set<Command> allCommands = getAllCommands(data, outState, startStates);
        OrientedGraph<Pair<String, Integer>> graph = new OrientedGraph<>();

        for (Command command: allCommands) {
            String com = command.getCommand();
            Pair<String, Integer> pairCom = new Pair<>(com, command.getWeight());
            for (String in: command.getInStates()) {
                graph.addEdge(new Pair<>(in, 0), pairCom);
            }
            for (String out: command.getOutStates()) {
                graph.addEdge(pairCom, new Pair<>(out, 0));
            }
        }

        return getCommandsList(graph);
    }

    private Set<Command> getAllCommands(Collection<Command> data, List<String> outState, Set<String> startStates) {
        Set<Command> allCommands = new HashSet<>();
        Queue<String> vertices = new LinkedList<>();
        vertices.addAll(outState);

        while (!vertices.isEmpty()) {
            String state = vertices.poll();
            if (startStates.contains(state)) {
                continue;
            }

            Set<Command> sources = getCommandsForOut(data, state);

            sources.removeAll(allCommands);

            allCommands.addAll(sources);

            Set<String> allIn = getAllIn(sources);
            vertices.addAll(allIn);
        }
        return allCommands;
    }

    private Set<Command> getCommandsForOut(Collection<Command> data, String out) {
        Set<Command> commands = new HashSet<>();
        for (Command com: data) {
            if (com.getOutStates().contains(out)) {
                commands.add(com);
            }
        }
        return commands;
    }

    private Set<String> getAllIn(Set<Command> commands) {
        Set<String> states = new HashSet<>();
        for (Command com: commands) {
            states.addAll(com.getInStates());
        }
        return states;
    }

    private List<String> getCommandsList(OrientedGraph<Pair<String, Integer>> graph) {
        List<String> commands = new ArrayList<>();
        Queue<Vertex<Pair<String, Integer>>> next = new LinkedList<>();
        next.addAll(graph.getRoot());

        while (!next.isEmpty()) {
            Vertex<Pair<String, Integer>> n = next.poll();
            if (commands.contains(n.getObject().getKey())) {
                continue;
            }
            commands.add(n.getObject().getKey());
            next.addAll(n.getIn());
        }

        return commands;
    }
}
