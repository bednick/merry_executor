package executor;

import bricks.Command;

import java.util.Collection;
import java.util.List;

public interface ISorter {
    List<Command> sort(Collection<Command> data, List<String> outFiles);
}
