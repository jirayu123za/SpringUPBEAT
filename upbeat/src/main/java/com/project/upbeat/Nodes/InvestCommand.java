package com.project.upbeat.Nodes;
import com.project.upbeat.GameProcess.Game;
import com.project.upbeat.Nodes.Node.*;

public class InvestCommand extends ExecuteNode {
    protected ExpressionNode expressionNode;

    public InvestCommand(ExpressionNode expressionNode){
        this.expressionNode = expressionNode;
    }

    @Override
    public boolean execute(Game bindings) {
        return bindings.invest(expressionNode.evaluate(bindings));
    }
}
