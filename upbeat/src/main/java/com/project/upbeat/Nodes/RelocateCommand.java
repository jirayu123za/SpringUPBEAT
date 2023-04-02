package com.project.upbeat.Nodes;

import com.project.upbeat.GameProcess.Game;
import com.project.upbeat.Nodes.Node.*;

public class RelocateCommand extends ExecuteNode {
    public RelocateCommand(){
    }

    @Override
    public boolean execute(Game bindings) {
        bindings.relocate();
        return true;
    }
}
