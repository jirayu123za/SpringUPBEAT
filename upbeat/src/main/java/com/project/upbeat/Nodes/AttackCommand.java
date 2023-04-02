package com.project.upbeat.Nodes;
import com.project.upbeat.GameProcess.Game;
import com.project.upbeat.Nodes.Node.*;

public class AttackCommand extends ExecuteNode {
    protected ExpressionNode expressionNode;
    protected DirectionNode direction;

    public AttackCommand(DirectionNode direction, ExpressionNode expressionNode){
        this.direction = direction;
        this.expressionNode = expressionNode;
    }

    @Override
    public boolean execute(Game bindings) {
        return bindings.attack(direction, expressionNode.evaluate(bindings));
    }
}
