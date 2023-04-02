package com.project.upbeat.Nodes;

import com.project.upbeat.GameProcess.Game;
import com.project.upbeat.Nodes.Node.*;

import java.util.List;

public class BlockStatementNode extends ExecuteNode {
    protected List<ExecuteNode> statements;

    public BlockStatementNode(List<ExecuteNode> statements){
        this.statements = statements;
    }

    @Override
    public boolean execute(Game bindings) {
        for(ExecuteNode statement : statements){
            if(!statement.execute(bindings)){
                return false;
            }
        }
        return true;
    }
}
