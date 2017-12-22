package executor;

import bricks.Command;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface ISorter {
    List<String> sort(Collection<Command> data, List<String> outFiles, Set<String> startStates);
}
