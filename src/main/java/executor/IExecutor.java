package executor;

import bricks.Command;

import java.util.List;

public interface IExecutor {
    void exec(List<Command> commands);
}
