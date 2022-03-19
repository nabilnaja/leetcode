package datastructure;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {

    public int val;
    public List<GraphNode> neighbors;

    public GraphNode() {
        val = 0;
        neighbors = new ArrayList<>();
    }
    public GraphNode(int val) {
        this.val = val;
        this.neighbors = new ArrayList<>();
    }
    public GraphNode(int val, ArrayList<GraphNode> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }
}
