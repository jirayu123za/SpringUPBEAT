package com.project.upbeat.Nodes;
import com.project.upbeat.GameProcess.Game;
import com.project.upbeat.Nodes.Node.*;

public class DoneCommand extends ExecuteNode {
    public DoneCommand(){
    }

    @Override
    public boolean execute(Game bindings) {
        return false;
    }
}
