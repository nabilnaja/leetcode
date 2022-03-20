package graph.leetcode133;

import datastructure.GraphNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SolutionRec {

    private final Map<GraphNode, GraphNode> visited = new HashMap<>();

    public GraphNode cloneGraph(GraphNode GraphNode) {
        if (GraphNode == null) {
            return null;
        }

        if (visited.containsKey(GraphNode)) {
            return visited.get(GraphNode);
        }

        GraphNode cloneGraphNode = new GraphNode(GraphNode.val, new ArrayList<>());

        visited.put(GraphNode, cloneGraphNode);

        for (GraphNode neighbor: GraphNode.neighbors) {
            cloneGraphNode.neighbors.add(cloneGraph(neighbor));
        }

        return cloneGraphNode;

    }
}


