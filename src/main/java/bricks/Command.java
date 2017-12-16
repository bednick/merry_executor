package bricks;

import java.util.Set;

public class Command {
    private Set<String> inStates;
    private Set<String> outStates;
    private String command;
    private int weight;

    public Command(Set<String> inStates, Set<String> outStates, String command, int weight) {
        this.inStates = inStates;
        this.outStates = outStates;
        this.command = command;
        this.weight = weight;
    }

    public Set<String> getInStates() {
        return inStates;
    }

    public Set<String> getOutStates() {
        return outStates;
    }

    public String getCommand() {
        return command;
    }

    public int getWeight() {
        return weight;
    }
}
