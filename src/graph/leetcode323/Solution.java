package graph.leetcode323;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int countComponents(int n, int[][] edges) {
        int components = 0;
        boolean[] visited = new boolean[n];

        List<Integer>[] adjList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            adjList[edge[0]].add(edge[1]);
            adjList[edge[1]].add(edge[0]);
        }

        for (int i = 0; i < edges.length; i++) {
            if(!visited[i]){
                components++;
                dfs(i, adjList, visited);
            }
        }
        return components;
    }
    private void dfs(int vertice, List<Integer>[] adjList, boolean[] visited){
        visited[vertice] = true;
        adjList[vertice].forEach(node -> {
            if(!visited[node]){
                dfs(node, adjList, visited);
            }
        });
    }
}


