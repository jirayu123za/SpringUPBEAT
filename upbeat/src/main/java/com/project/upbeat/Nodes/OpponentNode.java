package com.project.upbeat.Nodes;
import com.project.upbeat.GameProcess.Game;
import com.project.upbeat.Nodes.Node.*;

public class OpponentNode extends ExpressionNode {
    public OpponentNode(){

    }
    @Override
    public long evaluate(Game bindings) {
        return bindings.opponent();
    }

    @Override
    public String toString() {
        return "opponent";
    }
}
