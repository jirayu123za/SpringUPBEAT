package com.project.upbeat.Nodes;
import com.project.upbeat.GameProcess.Game;
import com.project.upbeat.Nodes.Node.*;

public class CollectCommand extends ExecuteNode {
    protected ExpressionNode expressionNode;

    public CollectCommand(ExpressionNode expressionNode){
        this.expressionNode = expressionNode;
    }

    @Override
    public boolean execute(Game bindings) {
        return bindings.collect(expressionNode.evaluate(bindings));
    }
}
