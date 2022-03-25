package graph.leetcode133;


import datastructure.GraphNode;

import java.util.*;

public class Solution {

    public GraphNode cloneGraphBFS(GraphNode node) {
        if (node == null) {
            return null;
        }

        Queue<GraphNode> q = new LinkedList<>();
        Map<GraphNode, GraphNode> visited = new HashMap<>();
        q.add(node);
        visited.put(node, new GraphNode(node.val, new ArrayList<>()));

        while(!q.isEmpty()){
            GraphNode n = q.poll();
            for (GraphNode neighbor: n.neighbors) {
                if (!visited.containsKey(neighbor)) {
                    visited.put(neighbor, new GraphNode(neighbor.val, new ArrayList<>()));
                    q.add(neighbor);
                }
                visited.get(n).neighbors.add(visited.get(neighbor));
            }
        }
        return visited.get(node);
    }
    public GraphNode cloneGraphDFS(GraphNode node) {
        if (node == null) {
            return null;
        }

        Stack<GraphNode> q = new Stack<>();
        Map<GraphNode, GraphNode> visited = new HashMap<>();
        q.add(node);
        visited.put(node, new GraphNode(node.val, new ArrayList<>()));

        while(!q.isEmpty()){
            GraphNode n = q.pop();
            for (GraphNode neighbor: n.neighbors) {
                if (!visited.containsKey(neighbor)) {
                    visited.put(neighbor, new GraphNode(neighbor.val, new ArrayList<>()));
                    q.add(neighbor);
                }
                visited.get(n).neighbors.add(visited.get(neighbor));
            }
        }
        return visited.get(node);
    }
}


