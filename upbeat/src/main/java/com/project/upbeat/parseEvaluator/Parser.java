package com.project.upbeat.parseEvaluator;

import com.project.upbeat.Nodes.Node.*;
import java.util.List;

public interface Parser {
    List<ExecuteNode> parse();
}
